package org.woodwhales.music.exception;

import cn.woodwhales.common.model.vo.RespVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import java.util.Objects;

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

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@ExceptionHandler(value = NoResourceFoundException.class)
	public void exception(NoResourceFoundException exception,
								  HttpServletRequest request,
								  HttpServletResponse response) throws Exception {
		log.error("{}", exception.getMessage(), exception);
		// 根据当前请求路径进行进行判断
		AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher("/admin/**");
		// admin 后端请求
		SecurityContext context = SecurityContextHolder.getContext();
		if (antPathRequestMatcher.matches(request)
				&& Objects.nonNull(context)
				&& context.getAuthentication().isAuthenticated()) {
			this.redirectStrategy.sendRedirect(request, response, "/admin/404");
		} else {
			this.redirectStrategy.sendRedirect(request, response, "/");
		}
	}

	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public RespVO<Void> exception(MethodArgumentNotValidException exception) {
		log.error("{}", exception.getMessage(), exception);
		String errorMessage = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		return RespVO.errorWithErrorMsg("请求非法");
	}



}
