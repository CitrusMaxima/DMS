package cn.edu.scu.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping(value="/conference")
public class ConferenceController {
	
	@RequestMapping(value="/adddConference.do")
	public String adddConference(HttpServletRequest request,HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "";
	}
	@RequestMapping(value="/getAllConference.do")
	public String getAllConference(HttpServletRequest request,HttpServletResponse response){
		return "";
	}
	

}
