package com.Javacristhian.tienda_api.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Javacristhian.tienda_api.seguridad.CustomUserDetailsService;
import com.Javacristhian.tienda_api.seguridad.JwtAuthenticationEntryPoint;
import com.Javacristhian.tienda_api.seguridad.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf()
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests()
		.antMatchers( "/usuario/**"
				
				
				).permitAll()
		.antMatchers(
				"/usuario/auth/**",
				"/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**"
				
				).permitAll()
		.anyRequest()
		.authenticated();
	
	http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
}
