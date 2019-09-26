package com.homolo.homolo.dao;

import com.homolo.homolo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: zh
 * @Description: 用户接口.
 * @Date: Created on 下午1:15 19-9-26
 */
@Service
public interface UserServiceDao {
	User loadUserByUsername(String username);
}
