package com.wy.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 验证异常自定义处理
 * 
 * @author cheng
 *
 */
@Component("customizeAccessDeniedHandler")
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// response.sendError(500);
		response.setStatus(403);
		Map<String, String> map = new HashMap<>();
		map.put("code", "500");
		map.put("msg", accessDeniedException.getMessage());

		// 失败返回json
		ObjectMapper objectMapper = new ObjectMapper();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().append(objectMapper.writeValueAsString(map));
	}

}
