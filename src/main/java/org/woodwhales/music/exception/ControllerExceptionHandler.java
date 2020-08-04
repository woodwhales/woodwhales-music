package org.woodwhales.music.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woodwhales.music.controller.resp.BaseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public BaseVO<Void> exception(Exception exception) {
		log.error("{}", exception);
		return BaseVO.fail(-1, "请求非法", null);
	}
	
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public BaseVO<Void> exception(MethodArgumentNotValidException exception) {
		log.error("{}", exception);
		String errorMessage = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		return BaseVO.fail(-1, errorMessage, null);
	}
	
	
	
}
