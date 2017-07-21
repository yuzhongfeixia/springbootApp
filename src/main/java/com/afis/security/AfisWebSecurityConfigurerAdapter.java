package com.afis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.afis.util.CookieConstants;

@Configuration
@EnableWebSecurity
@ConfigurationProperties
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AfisWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	//通过登录页登录验证
	@Autowired
	private AfisAuthenticationProvider provider;

	@Autowired
	private AfisSavedRequestAwareAuthenticationSuccessHandler successHandler;

	@Autowired
	private AfisFilterSecurityInterceptor afisFilterSecurityInterceptor;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();

		http.csrf().disable().authorizeRequests().antMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login.htm").defaultSuccessUrl("/index.htm").successHandler(successHandler).loginProcessingUrl("/login").permitAll()
				.and().logout().deleteCookies(CookieConstants.WEB_USERNAME).permitAll();

		http.addFilterBefore(afisFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}

}
