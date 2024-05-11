package org.woodwhales.music.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.woodwhales.music.security.MyAuthenticationFailureHandler;

/**
 * spring security 配置文件
 * @author woodwhales
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin() 								// 定义当需要用户登录时候，转到的登录页面。
				.loginPage("/admin/login")	 					// 设置登录页面
				.loginProcessingUrl("/admin/loginTo") 			// 自定义的登录接口，如果没有配置，则使用：loginPage
				.defaultSuccessUrl("/admin/")					// login 成功之后，默认跳转的页面
				// .failureForwardUrl() // 本质是添加了一个 链接重定向处理器（failureHandler）： = org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler
				.failureHandler(myAuthenticationFailureHandler.forwardUrl("/admin/login"))
				.and()

				// ========== 登出配置 ==========
				.logout()
				.logoutUrl("/admin/logout")
				.logoutSuccessUrl("/admin/login")  				// logout 成功之后，默认跳转的页面
				.permitAll()
				.and()

				// ========== 定义哪些URL需要被保护、哪些不需要被保护 ==========
				.authorizeRequests()

				.antMatchers("/", "/index", "/admin/login")
				.permitAll()		// 设置所有人都可以访问登录页面

				.anyRequest()
				.authenticated() 				// 任何请求,登录后可以访问
				.and()
				.csrf()
				.disable();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	 }

	@Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/admin/fonts/**",
				"/admin/css/**",
				"/admin/images/**",
				"/admin/js/**",
				"/admin/lib/**",
				"/webjars/**",
				"/images/**",
				"/css/**",
				"/fonts/**",
				"/js/**",
				"/**.png",
				"/**.ico",
				"/favicon.ico");
    }

}