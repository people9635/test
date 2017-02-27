package com.tccp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tccp.entity.User;
import com.tccp.service.LoginService;
import com.tccp.websocket.WebSocketUtil;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	/**
	 * 电话接入时向前端展示用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/telAccess")
	public void getAllUser(HttpServletRequest request){
		String tel = request.getParameter("tel");
		User u = loginService.telAccess(tel);
		try {
			new WebSocketUtil().sendJson(u.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
