package com.wy.system.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("system")
@Log4j2
public class LoginController {
	
	@RequestMapping("unlogin")
	public String unLogin() {
		return "unlogin";
	}
	
	@RequestMapping("loginfail")
	public String loginFail() {
		return "loginfail";
	}
	
	@RequestMapping("loginsuccess")
	public String loginSuccess(Principal principal) {
		
		return "loginsuccess";
	}
	
	@RequestMapping("logout")
	public String logout() {
		return "logout";
	}
}
