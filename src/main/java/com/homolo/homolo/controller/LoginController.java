package com.homolo.homolo.controller;

import com.homolo.homolo.service.UserServiceImpl;
import com.homolo.homolo.service.impl.UserDateilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: ZH
 * @Description:
 * @Date: 19-9-9 下午12:40
 */
@Controller
public class LoginController {

	@Autowired
	private UserDateilServiceImpl userDetailService;

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = {"/", "/hello"}, method = RequestMethod.GET)
	public String welcome() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		this.logger.info("用户信息:" + authentication.getName());
		return "hello";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "loginTest";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "loginTest";
	}

}
