package cn.edu.scu.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserManagementController {
	
	@RequestMapping(value="/adduser.do")
	public  String addUser(HttpServletRequest request,HttpServletResponse response){
		return "";
	}
	@RequestMapping(value="/getuser.do")
	public  String getUser(HttpServletRequest request,HttpServletResponse response){
		return "";
		
	}

}
