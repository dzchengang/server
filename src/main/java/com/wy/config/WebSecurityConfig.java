package com.wy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    CustomizeAccessDeniedHandler customizeAccessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()// 配置权限
				.anyRequest().authenticated()// 任意请求需要登录
				.and()
				.formLogin()// 开启formLogin默认配置
				.loginPage("/system/unlogin").permitAll()// 请求时未登录跳转接口
				.failureUrl("/system/loginfail")// 用户密码错误跳转接口
				.defaultSuccessUrl("/system/loginsuccess", true)// 登录成功跳转接口
				.loginProcessingUrl("/system/login")// post登录接口，登录验证由系统实现
				.and()
				.logout()// 配置注销
				.logoutUrl("/logout")// 注销接口
				.logoutSuccessUrl("/system/logout").permitAll()// 注销成功跳转接口
				.and()
				.exceptionHandling().accessDeniedHandler(customizeAccessDeniedHandler)
				.and()
				.csrf().disable(); // 禁用csrf

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 设置userservice 设置 password
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
}
