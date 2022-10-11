package com.decidir.sdk.dto.auth3ds;

import java.io.Serializable;

public class Auth3dsData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String device_type;
	private String accept_header;
	private String user_agent;
	private String ip;
	private boolean java_enabled;
	private String language;
	private String color_depth;
	private Long screen_height;
	private Long screen_width;
	private Long time_zone_offset;
	
	
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getAccept_header() {
		return accept_header;
	}
	public void setAccept_header(String accept_header) {
		this.accept_header = accept_header;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isJava_enabled() {
		return java_enabled;
	}
	public void setJava_enabled(boolean java_enabled) {
		this.java_enabled = java_enabled;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getColor_depth() {
		return color_depth;
	}
	public void setColor_depth(String color_depth) {
		this.color_depth = color_depth;
	}
	public Long getScreen_height() {
		return screen_height;
	}
	public void setScreen_height(Long screen_height) {
		this.screen_height = screen_height;
	}
	public Long getScreen_width() {
		return screen_width;
	}
	public void setScreen_width(Long screen_width) {
		this.screen_width = screen_width;
	}
	public Long getTime_zone_offset() {
		return time_zone_offset;
	}
	public void setTime_zone_offset(Long time_zone_offset) {
		this.time_zone_offset = time_zone_offset;
	}
	
	

}
