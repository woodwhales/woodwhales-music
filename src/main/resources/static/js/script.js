﻿var showFriendly = function(friendlyInfos) {
	if(friendlyInfos && friendlyInfos.length > 0) {
		let friendly = document.getElementById("friendly");
		let str = ''
		friendlyInfos.forEach(data => {
			str += '<a class="friendlyLink" href="' + data.url + '" target="_blank">' + data.name + '</a>';
		})
		friendly.innerHTML = str
	}
}

var clickPlayer = (id) => {
	fetch('./clickPlay?t=' + new Date().getTime(), {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			time: new Date().getTime(),
			id: id
		})
	})
	.then(response => response.json())
	.then(data => {
		if (data.code === 0) {
			data.data.visits.count;
			data.data.clicks.count;
			let siteStatistics = document.getElementById("siteStatistics");
			let str = `访问人次：${data.data.visits.count}，点击人次：${data.data.clicks.count}`
			siteStatistics.innerHTML = str
		}
	})
	.catch(error => console.error('Error:', error));
}

var playMusic = function(musicArray) {
	var repeat = localStorage.repeat || 0, shuffle = localStorage.shuffle
			|| "false", continous = true, autoplay = true, playlist = musicArray;

	// Load playlist
	for (var i = 0; i < playlist.length; i++) {
		var item = playlist[i];
		$("#playlist").append(
				"<li> " + item.title + " - " + item.artist + "</li>");
	}

	var time = new Date(), currentTrack = shuffle === "true" ? time.getTime()
			% playlist.length : 0, trigger = false, audio, timeout, isPlaying, playCounts;

	var play = function() {
		audio.play();
		$(".playback").addClass("playing");
		timeout = setInterval(updateProgress, 500);
		isPlaying = true;
	};

	var pause = function() {
		audio.pause();
		$(".playback").removeClass("playing");
		clearInterval(updateProgress);
		isPlaying = false;
	};

	// Update progress
	var setProgress = function(value) {
		var currentSec = parseInt(value % 60) < 10 ? "0" + parseInt(value % 60)
				: parseInt(value % 60), ratio = (value / audio.duration) * 100;

		$(".timer").html(parseInt(value / 60) + ":" + currentSec);
		$(".progress .pace").css("width", ratio + "%");
		$(".progress .slider a").css("left", ratio + "%");
	};

	var updateProgress = function() {
		setProgress(audio.currentTime);
	};

	// Progress slider
	$(".progress .slider").slider({
		step : 0.1,
		slide : function(event, ui) {
			$(this).addClass("enable");
			setProgress((audio.duration * ui.value) / 100);
			clearInterval(timeout);
		},
		stop : function(event, ui) {
			audio.currentTime = (audio.duration * ui.value) / 100;
			$(this).removeClass("enable");
			timeout = setInterval(updateProgress, 500);
		},
	});

	// Volume slider
	var setVolume = function(value) {
		audio.volume = localStorage.volume = value;
		$(".volume .pace").css("width", value * 100 + "%");
		$(".volume .slider a").css("left", value * 100 + "%");
	};

	var volume = localStorage.volume || 0.5;
	$(".volume .slider").slider({
		max : 1,
		min : 0,
		step : 0.01,
		value : volume,
		slide : function(event, ui) {
			setVolume(ui.value);
			$(this).addClass("enable");
			$(".mute").removeClass("enable");
		},
		stop : function() {
			$(this).removeClass("enable");
		},
	}).children(".pace").css("width", volume * 100 + "%");

	$(".mute").click(function() {
		if ($(this).hasClass("enable")) {
			setVolume($(this).data("volume"));
			$(this).removeClass("enable");
		} else {
			$(this).data("volume", audio.volume).addClass("enable");
			setVolume(0);
		}
	});

	// Switch track
	var switchTrack = function(i) {
		if (i < 0) {
			track = currentTrack = playlist.length - 1;
		} else if (i >= playlist.length) {
			track = currentTrack = 0;
		} else {
			track = i;
		}

		$("audio").remove();
		loadMusic(track);
		if (isPlaying == true)
			play();
	};

	// Shuffle
	var shufflePlay = function() {
		var time = new Date(), lastTrack = currentTrack;
		currentTrack = time.getTime() % playlist.length;
		if (lastTrack == currentTrack)
			++currentTrack;
		switchTrack(currentTrack);
	};

	// Fire when track ended
	var ended = function() {
		pause();
		audio.currentTime = 0;
		playCounts++;
		if (continous == true)
			isPlaying = true;
		if (repeat == 1) {
			play();
		} else {
			if (shuffle === "true") {
				shufflePlay();
			} else {
				if (repeat == 2) {
					switchTrack(++currentTrack);
				} else {
					if (currentTrack < playlist.length)
						switchTrack(++currentTrack);
				}
			}
		}
	};

	var beforeLoad = function() {
		var endVal = this.seekable && this.seekable.length ? this.seekable
				.end(0) : 0;
		$(".progress .loaded").css("width",
				(100 / (this.duration || 1)) * endVal + "%");
	};

	// Fire when track loaded completely
	var afterLoad = function() {
		if (autoplay == true)
			play();
	};

	// Load track
	var loadMusic = function(i) {
		var item = playlist[i], newaudio = $("<audio>").html(
				'<source src="' + item.audioUrl + '"><source src="' + item.ogg
						+ '">').appendTo("#player");
		$(".cover").html(
				'<img src="' + item.coverUrl + '" alt="' + item.album + '">');
		$(".tag").html(
				"<strong>" + item.title + '</strong><span class="artist">'
						+ item.artist + '</span><span class="album">'
						+ item.album + "</span>");
		$("#playlist li").removeClass("playing").eq(i).addClass("playing");
		audio = newaudio[0];
		audio.id = item.id;
		audio.volume = $(".mute").hasClass("enable") ? 0 : volume;
		audio.addEventListener("progress", beforeLoad, false);
		audio.addEventListener("durationchange", beforeLoad, false);
		audio.addEventListener("canplay", afterLoad, false);
		audio.addEventListener("ended", ended, false);
		audio.addEventListener('play', () => {
			clickPlayer(audio.id)
		});
	};

	loadMusic(currentTrack);
	$(".playback").on("click", function() {
		if ($(this).hasClass("playing")) {
			pause();
		} else {
			play();
		}
	});
	$(".rewind").on("click", function() {
		if (shuffle === "true") {
			shufflePlay();
		} else {
			switchTrack(--currentTrack);
		}
	});
	$(".fastforward").on("click", function() {
		if (shuffle === "true") {
			shufflePlay();
		} else {
			switchTrack(++currentTrack);
		}
	});
	$("#playlist li").each(function(i) {
		var _i = i;
		$(this).on("click", function() {
			switchTrack(_i);
		});
	});

	if (shuffle === "true")
		$(".shuffle").addClass("enable");
	if (repeat == 1) {
		$(".repeat").addClass("once");
	} else if (repeat == 2) {
		$(".repeat").addClass("all");
	}

	$(".repeat").on("click", function() {
		if ($(this).hasClass("once")) {
			repeat = localStorage.repeat = 2;
			$(this).removeClass("once").addClass("all");
		} else if ($(this).hasClass("all")) {
			repeat = localStorage.repeat = 0;
			$(this).removeClass("all");
		} else {
			repeat = localStorage.repeat = 1;
			$(this).addClass("once");
		}
	});

	$(".shuffle").on("click", function() {
		if ($(this).hasClass("enable")) {
			shuffle = localStorage.shuffle = "false";
			$(this).removeClass("enable");
		} else {
			shuffle = localStorage.shuffle = "true";
			$(this).addClass("enable");
		}
	});
}
