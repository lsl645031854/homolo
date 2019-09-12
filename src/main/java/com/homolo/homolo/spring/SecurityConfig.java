package com.homolo.homolo.spring;

import com.homolo.homolo.service.impl.UserDateilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: ZH
 * @Description:
 * @Date: 19-9-6 下午7:47
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDateilServiceImpl userDateilService;
	//security配置,EnableGlobalMethodSecurity 允许配置注解
	// 教程：http://www.spring4all.com/article/428
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//内存用户
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhuhui").password(new BCryptPasswordEncoder().encode("zhuhui@#")).roles("admin");
		auth.userDetailsService(userDateilService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//控制访问权限
		http.authorizeRequests()
//				.antMatchers("/hello").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/hello")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();
	}
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
