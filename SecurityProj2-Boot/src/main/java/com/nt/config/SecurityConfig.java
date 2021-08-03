package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
		         .usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
		         .authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/welcome").permitAll().antMatchers("/list_countries").access("hasAnyRole('ROLE_CUSTOMER','ROLE_AGENT')")
             .and().formLogin().and().rememberMe()
             .and().logout().and().exceptionHandling().accessDeniedPage("/access_denied.jsp").and()
             .sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);		

	}

}
