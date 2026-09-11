package org.woodwhales.music.exception;

import cn.woodwhales.common.model.vo.RespVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.woodwhales.music.config.TraceIdFilter;

import java.util.Objects;

/**
 * 全局异常处理器：按异常类型分层返回不同 HTTP 状态码，并透传 traceId
 *
 * @author woodwhales
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/**
	 * 参数校验失败 -> 400
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<RespVO<Void>> handleInvalid(MethodArgumentNotValidException exception,
													  HttpServletResponse response) {
		String msg = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		log.warn("traceId={}, 参数校验失败: {}", MDC.get(TraceIdFilter.TRACE_ID_KEY), msg);
		return build(response, HttpStatus.BAD_REQUEST, msg);
	}

	/**
	 * 已登录但无权限 -> 403
	 */
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<RespVO<Void>> handleAccessDenied(AccessDeniedException exception,
														   HttpServletResponse response) {
		String msg = "无权限访问";
		log.warn("traceId={}, 无权限访问: {}", MDC.get(TraceIdFilter.TRACE_ID_KEY), exception.getMessage());
		return build(response, HttpStatus.FORBIDDEN, msg);
	}

	/**
	 * 未登录或登录已过期 -> 401
	 */
	@ExceptionHandler(value = AuthenticationException.class)
	public ResponseEntity<RespVO<Void>> handleAuthentication(AuthenticationException exception,
															 HttpServletResponse response) {
		String msg = "未登录或登录已过期";
		log.warn("traceId={}, 认证失败: {}", MDC.get(TraceIdFilter.TRACE_ID_KEY), exception.getMessage());
		return build(response, HttpStatus.UNAUTHORIZED, msg);
	}

	/**
	 * 静态资源/路由不存在：保留原有重定向逻辑
	 */
	@ExceptionHandler(value = NoResourceFoundException.class)
	public void handleNoResourceFound(NoResourceFoundException exception,
									  HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		log.error("traceId={}, {}", MDC.get(TraceIdFilter.TRACE_ID_KEY), exception.getMessage(), exception);
		// 根据当前请求路径进行判断
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

	/**
	 * 其他未分类异常 -> 500
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<RespVO<Void>> handleException(Exception exception,
														HttpServletResponse response) {
		log.error("traceId={}, 服务器内部错误: {}", MDC.get(TraceIdFilter.TRACE_ID_KEY),
				exception.getMessage(), exception);
		return build(response, HttpStatus.INTERNAL_SERVER_ERROR, "服务器内部错误");
	}

	/**
	 * 统一构建响应：透传 traceId 到响应头，并用 ResponseEntity 控制 HTTP 状态码
	 */
	private ResponseEntity<RespVO<Void>> build(HttpServletResponse response, HttpStatus status, String msg) {
		String traceId = MDC.get(TraceIdFilter.TRACE_ID_KEY);
		if (traceId != null && !traceId.isEmpty()) {
			response.setHeader(TraceIdFilter.TRACE_ID_HEADER, traceId);
		}
		return ResponseEntity.status(status).body(RespVO.errorWithErrorMsg(msg));
	}

}
