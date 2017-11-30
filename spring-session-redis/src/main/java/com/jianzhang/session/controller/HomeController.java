package com.jianzhang.session.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 测试控制器类
 * @author Jian Jang
 * @version 1.0 2017年11月29日
 */
@Controller
public class HomeController {

	@GetMapping("/log")
	public String index(ModelMap modelMap) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		modelMap.put("server", address.getHostAddress());
		return "login";
	}

	@RequestMapping("/login")
	public String index(HttpServletRequest request, User user, ModelMap modelMap)
			throws UnknownHostException {
		HttpSession session = request.getSession();
		InetAddress address = InetAddress.getLocalHost();
		String loginUser = (String) session.getAttribute("user");
		if (StringUtils.isEmpty(user.getUsername())) {
			return "login";
		}
		if (!StringUtils.isEmpty(loginUser)) {
			modelMap.put("username", loginUser);
			modelMap.put("server", address.getHostAddress());
		} else {
			modelMap.put("username", user.getUsername());
			modelMap.put("server", address.getHostAddress());
			session.setAttribute("user", user.getUsername());
			session.setAttribute("server", address.getHostAddress());
		}
		System.out.println("登录成功：" + address.getHostAddress());
		return "login";
	}

	@RequestMapping("/buy")
	public String buy(HttpServletRequest request, ModelMap modelMap) throws UnknownHostException {
		HttpSession session = request.getSession();
		InetAddress address = InetAddress.getLocalHost();
		String loginUser = (String) session.getAttribute("user");
		if (!StringUtils.isEmpty(loginUser)) {
			modelMap.put("username", loginUser);
			modelMap.put("message", "购买成功" + address.getHostAddress());
			System.out.println("购买成功" + address.getHostAddress());
		} else {
			modelMap.put("message", "购买失败，请先登录" + address.getHostAddress());
			modelMap.put("server", address.getHostAddress());
			System.out.println("购买失败，请先登录" + address.getHostAddress());
		}
		return "login";
	}
}
