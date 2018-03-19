package cn.edu.scu.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/conference")
public class ConferenceController {
	
	@RequestMapping(value="/adddConference.do")
	public String adddConference(HttpServletRequest request,HttpServletResponse response){
		
		return "";
	}
	@RequestMapping(value="/getAllConference.do")
	public String getAllConference(HttpServletRequest request,HttpServletResponse response){
		return "";
	}
	

}
