package com.homolo.homolo.dao;

import com.homolo.homolo.entity.User;
/**
 * @Author: zh
 * @Description: 用户接口.
 * @Date: Created on 下午1:15 19-9-26
 */
public interface UserServiceDao {
	User loadUserByUsername(String username);
}
