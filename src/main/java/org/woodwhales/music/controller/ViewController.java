package org.woodwhales.music.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.music.model.MusicInfo;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@Controller
public class ViewController {
	
	private Gson gson = new Gson();

	@GetMapping({"", "index"})
	public String index(Model model) {
		
		String jsonArray = "[\n" + 
				"    {\n" + 
				"        \"title\":\"Someone Like You\",\n" + 
				"        \"artist\":\"Adele\",\n" + 
				"        \"album\":\"Someone Like You\",\n" + 
				"        \"cover\":\"pic/some_one_like_you.jpg\",\n" + 
				"        \"mp3\":\"music/some_one_like_you.m4a\"\n"
				+ "},"
				+ "{" + 
				"        \"title\":\"红日\",\n" + 
				"        \"artist\":\"李克勤\",\n" + 
				"        \"album\":\"红日\",\n" + 
				"        \"cover\":\"pic/hong_ri.jpg\",\n" + 
				"        \"mp3\":\"music/hong_ri.m4a\"\n" + 
				"        " + 
				"    }\n" + 
				"]";
		
		List<MusicInfo> musicInfoList = gson.fromJson(jsonArray, new TypeToken<List<MusicInfo>>() {}.getType());
		model.addAttribute("musicInfoList", musicInfoList);
		return "index";
	}
	
}
