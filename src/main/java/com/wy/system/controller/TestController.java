package com.wy.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("test")
@Log4j2
public class TestController {
	
	@RequestMapping("admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		int a=1/0;
		return "admin";
	}

	@RequestMapping("user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user() {
		return "user";
	}
}
