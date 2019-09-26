package com.homolo.homolo.service.impl;

import com.homolo.homolo.dao.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private UserServiceDao userServiceDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.homolo.homolo.entity.User userInfo = this.userServiceDao.loadUserByUsername(username);
		if (userInfo == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		User user  = new User(userInfo.getUsername(), userInfo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		return user;
	}
}
