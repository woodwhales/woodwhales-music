package org.woodwhales.music.exception;

import cn.woodwhales.common.model.result.OpResult;
import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.model.SysConfigVo;
import org.woodwhales.music.service.sysConfig.SysConfigService;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	@Autowired
	private SysConfigService sysConfigService;

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public RespVO<Void> exception(Exception exception) {
		log.error("{}", exception.getMessage(), exception);
		return RespVO.errorWithErrorMsg("请求非法");
	}

	@ExceptionHandler(value = NoResourceFoundException.class)
	public ModelAndView exception(NoResourceFoundException exception) {
		log.error("{}", exception.getMessage(), exception);
		ModelAndView modelAndView = new ModelAndView("admin2/404");
		OpResult<SysConfigVo> opResult = sysConfigService.getConfig(new SysConfigGetRequestBody("admin"));
		modelAndView.addObject(opResult.getData().getConfigKey(), opResult.getData().getContent());
		return modelAndView;
	}
	
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public RespVO<Void> exception(MethodArgumentNotValidException exception) {
		log.error("{}", exception.getMessage(), exception);
		String errorMessage = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		return RespVO.errorWithErrorMsg("请求非法");
	}
	
	
	
}
