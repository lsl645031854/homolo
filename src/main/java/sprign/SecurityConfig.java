package sprign;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: ZH
 * @Description:
 * @Date: 19-9-6 下午7:47
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//security配置,EnableGlobalMethodSecurity 允许配置注解
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//???
		auth.inMemoryAuthentication().withUser("zhuhui").password("zhuhui@#").roles("admin");
		auth.inMemoryAuthentication().withUser("lishuailin").password("lishuailin@#").roles("admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//控制访问权限

	}
}
