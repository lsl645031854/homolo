package com.homolo.homolo.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author: ZH
 * @Description:
 * @Date: 19-9-10 下午4:59
 */
@Component("userDetailsManager")
public class UserDateilServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//模拟查询数据库用户
		User user  = new User(username, "123", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		return user;
	}
}
