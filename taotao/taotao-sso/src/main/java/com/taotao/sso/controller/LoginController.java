package com.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.sso.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult login(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		TaotaoResult result = loginService.login(username, password, request, response);
		return result;
	}

	@RequestMapping("/user/logout")
	public String logout(String redirect,HttpServletRequest request, HttpServletResponse response) {
		TaotaoResult result = loginService.logout(request,response);
		if(result.getStatus()==200){
			return "redirect:"+redirect;
		}else{
			//要跳转到错误页面
			return "redirect:"+redirect;
		}
	}
	
}
