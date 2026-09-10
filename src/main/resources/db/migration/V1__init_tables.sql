-- --------------------------------------------------------
-- woodwhales-music 库表结构（PostgreSQL）
-- 状态字段约定（status）：0-已启用，1-已停用，2-已删除（MyBatis-Plus 逻辑删除 delval=2）
-- 存活行的唯一性通过部分唯一索引（WHERE status <> 2）保证，与逻辑删除兼容
-- --------------------------------------------------------

-- 文件记录表（x-file-storage）
CREATE TABLE IF NOT EXISTS file_detail (
    id bigint PRIMARY KEY,
    url varchar(512) NOT NULL,
    size bigint,
    filename varchar(256),
    original_filename varchar(256),
    base_path varchar(256),
    path varchar(256),
    ext varchar(32),
    content_type varchar(128),
    platform varchar(32),
    th_url varchar(512),
    th_filename varchar(256),
    th_size bigint,
    th_content_type varchar(128),
    object_id varchar(32),
    object_type varchar(32),
    metadata text,
    user_metadata text,
    th_metadata text,
    th_user_metadata text,
    attr text,
    file_acl varchar(32),
    th_file_acl varchar(32),
    hash_info text,
    upload_id varchar(128),
    upload_status integer,
    create_time timestamp,
    status smallint NOT NULL DEFAULT 0,
    sha256 char(64) NOT NULL
);
COMMENT ON TABLE file_detail IS '文件记录表';
CREATE INDEX IF NOT EXISTS idx_file_detail_url ON file_detail (url);
CREATE INDEX IF NOT EXISTS idx_file_detail_sha256 ON file_detail (sha256);

-- 文件分片信息表，仅在手动分片上传时使用（x-file-storage）
CREATE TABLE IF NOT EXISTS file_part_detail (
    id bigint PRIMARY KEY,
    platform varchar(32),
    upload_id varchar(128),
    e_tag varchar(255),
    part_number integer,
    part_size bigint,
    hash_info text,
    create_time timestamp,
    status smallint NOT NULL DEFAULT 0
);
COMMENT ON TABLE file_part_detail IS '文件分片信息表，仅在手动分片上传时使用';

-- 音乐表
CREATE TABLE IF NOT EXISTS music_info (
    id bigint PRIMARY KEY,
    title varchar(200) NOT NULL,
    artist varchar(200),
    album varchar(180),
    sort integer DEFAULT 1,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now(),
    link_status integer NOT NULL DEFAULT 0
);
COMMENT ON TABLE music_info IS '音乐表';
CREATE INDEX IF NOT EXISTS idx_music_info_status_sort ON music_info (status, sort);

-- 音乐链接信息表
CREATE TABLE IF NOT EXISTS music_info_link (
    id bigint PRIMARY KEY,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now(),
    link_url varchar(1024),
    link_type integer NOT NULL DEFAULT 0,
    link_source integer NOT NULL DEFAULT 0,
    music_id bigint NOT NULL
);
COMMENT ON TABLE music_info_link IS '音乐链接信息表';
CREATE INDEX IF NOT EXISTS idx_music_info_link_music ON music_info_link (music_id, link_type, link_source);

-- 音乐标签表
CREATE TABLE IF NOT EXISTS music_tag (
    id bigint PRIMARY KEY,
    music_id bigint NOT NULL DEFAULT 0,
    tag_id bigint NOT NULL DEFAULT 0,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now()
);
COMMENT ON TABLE music_tag IS '音乐标签表';
CREATE UNIQUE INDEX IF NOT EXISTS uk_music_tag_alive ON music_tag (music_id, tag_id) WHERE status <> 2;

-- 系统配置表
CREATE TABLE IF NOT EXISTS sys_config (
    id bigint PRIMARY KEY,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now(),
    config_key varchar(100) NOT NULL,
    config_content text NOT NULL
);
COMMENT ON TABLE sys_config IS '系统配置表';
CREATE UNIQUE INDEX IF NOT EXISTS uk_sys_config_key_alive ON sys_config (config_key) WHERE status <> 2;

-- 用户表
CREATE TABLE IF NOT EXISTS sys_user (
    id bigint PRIMARY KEY,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now(),
    username varchar(120) NOT NULL,
    password varchar(300) NOT NULL,
    two_factor_secret varchar(300) NOT NULL,
    two_factor_enabled boolean NOT NULL DEFAULT FALSE
);
COMMENT ON TABLE sys_user IS '用户表';
CREATE UNIQUE INDEX IF NOT EXISTS uk_sys_user_username_alive ON sys_user (username) WHERE status <> 2;

-- 标签表
CREATE TABLE IF NOT EXISTS tag_info (
    id bigint PRIMARY KEY,
    status smallint NOT NULL DEFAULT 0,
    gmt_created timestamp NOT NULL DEFAULT now(),
    gmt_modified timestamp NOT NULL DEFAULT now(),
    name varchar(150) NOT NULL
);
COMMENT ON TABLE tag_info IS '标签表';
CREATE UNIQUE INDEX IF NOT EXISTS uk_tag_info_name_alive ON tag_info (name) WHERE status <> 2;
