package com.wy.config;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wy.pub.dto.ResultDto;

import lombok.extern.log4j.Log4j2;

/**
 * 统一异常处理  作用在 controller层 不能拦截springsecurity的401错误
 * @author cheng
 *
 */
@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResultDto> handler(Exception e) {
		return new ResponseEntity<>(new ResultDto(-1, "cuowu"), HttpStatus.BAD_REQUEST);	
	}
}
