package org.woodwhales.music.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.woodwhales.music.security.MyAuthenticationFailureHandler;
import org.woodwhales.music.security.MyAuthenticationSuccessHandler;

/**
 * spring security 配置文件
 * @author woodwhales
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 禁用basic明文验证
		http.httpBasic(Customizer.withDefaults());
		// 前后端分离架构不需要csrf保护
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/", "/index", "/error").permitAll()
					.requestMatchers(
							"/admin/fonts/**",
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
							"/favicon.ico").permitAll()
					.anyRequest().authenticated();
		});

		http.formLogin(formLogin ->
			formLogin.loginPage("/admin/login").permitAll()
					.loginProcessingUrl("/admin/loginTo").permitAll()
					.successHandler(new MyAuthenticationSuccessHandler("/admin/"))
					.failureHandler(new MyAuthenticationFailureHandler("/admin/login"))
		);
		http.logout(formLogout ->
				formLogout.logoutUrl("/logout").permitAll()
						.logoutSuccessUrl("/login").permitAll()
						.invalidateHttpSession(true));
		http.securityContext(securityContext -> securityContext.requireExplicitSave(false));
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return new ProviderManager(authenticationProvider);
	}

}
