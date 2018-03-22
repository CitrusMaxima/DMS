package cn.edu.scu.dms.controller;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scu.dms.model.Meeting;
import cn.edu.scu.dms.model.MeetingStatistical;
import cn.edu.scu.dms.services.ConferenceServices;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping(value="/conference")
public class ConferenceController {
	
	@Autowired
	ConferenceServices conferenceServices;

	@RequestMapping(value="/adddConference.do")
	public String adddConference(HttpServletRequest request,HttpServletResponse response) throws ParseException{

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Meeting meeting=new Meeting();
		System.out.println("登记开始");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		NumberFormat numberformat1 = NumberFormat.getNumberInstance();
		numberformat1.setGroupingUsed(false);
		numberformat1.setMinimumIntegerDigits(7);

		NumberFormat numberformat2 = NumberFormat.getNumberInstance();
		numberformat2.setGroupingUsed(false);
		numberformat2.setMinimumIntegerDigits(3);

		String mid=null;
		Meeting isExist=null;
		Random ranInt=new Random();

		do{
			mid=numberformat1.format(ranInt.nextInt(1000000))+numberformat2.format(ranInt.nextInt(100));
			isExist=conferenceServices.getMeetingById(mid);
		}while(isExist!=null);

		String timeString=request.getParameter("mtime");
		Date mtime =  formatter.parse(timeString);
		String host =request.getParameter("host");//会议性质
		String place=request.getParameter("place");
		String names=request.getParameter("names");
		Boolean ishold=true;
		String hold=request.getParameter("ishold");
		if(hold==null)
			ishold=false;
		String document=request.getParameter("document");
		String holder=request.getParameter("holder");
		String content=request.getParameter("content");

		String test = request.getParameter("temp");
		
		meeting.setMid(mid);
		meeting.setMtime(mtime);
		meeting.setPlace(place);
		meeting.setHost(host);
		meeting.setNames(names);
		meeting.setIshold(ishold);
		meeting.setDocument(test);
		meeting.setHolder(holder);
		meeting.setContent(content);
		
		try {
			conferenceServices.registerConference(meeting);
		} catch (Exception e) {
			 request.setAttribute("flag","registerFail");
			return "forward:/Meeting-Add.jsp";
		}

		List<Meeting> meetings=null;
        try {
			meetings=conferenceServices.getAllMeetings();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");
		}
		request.setAttribute("flag","registerSuccess");
		request.setAttribute("meetings",meetings);
		return "forward:/Meeting.jsp";
	}
	@RequestMapping(value="/getAllConference.do")
	public String getAllConference(HttpServletRequest request,HttpServletResponse response){

		List<Meeting> meetings=null;
		try {
			meetings=conferenceServices.getAllMeetings();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取会议列表出错");
		}
		request.setAttribute("meetings",meetings);
		return "forward:/Meeting.jsp";
	}
	@RequestMapping(value="/updateConference.do")
	public  String updateConference(HttpServletRequest request,HttpServletResponse response) throws ParseException{

	   try {
		request.setCharacterEncoding("UTF-8");
	   } catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	   }
	   String mid=request.getParameter("mid");

	   Meeting meeting=new Meeting();
	   java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

		String timeString=request.getParameter("mtime");
		Date mtime = formatter.parse(timeString);
		String host =request.getParameter("host");
		String place=request.getParameter("place");
		String names=request.getParameter("names");
		Boolean ishold=true;
		String hold=request.getParameter("ishold");
		if(hold==null)
			ishold=false;
		String document=request.getParameter("document");
		String holder=request.getParameter("holder");
		String content=request.getParameter("content");

		meeting.setMid(mid);
		meeting.setMtime(mtime);
		meeting.setHost(host);
		meeting.setPlace(place);
		meeting.setNames(names);
		meeting.setIshold(ishold);
		meeting.setDocument(document);
		meeting.setHolder(holder);
		meeting.setContent(content);

		try {
        	conferenceServices.updateMeeting(meeting);
		} catch (Exception e) {
		   request.setAttribute("flag", "modifyFail");
		}

		List<Meeting> meetings=null;
        try {
			meetings=conferenceServices.getAllMeetings();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");
		}
		request.setAttribute("meetings",meetings);
		request.setAttribute("flag","modifySuccess");
		return "forward:/Meeting.jsp";
	 }
	@RequestMapping(value="/getMeetingById.do")
	public String getMeetingById(HttpServletRequest request,HttpServletResponse response){

		String mid=request.getParameter("mid");
		String jsp=request.getParameter("jsp");

		Meeting meeting=conferenceServices.getMeetingById(mid);
		request.setAttribute("meeting",meeting);
		return "forward:/"+jsp;
	}
	@RequestMapping("/deleteMeetingById.do")
	public String deleteMeetingById(HttpServletRequest request,HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mid=request.getParameter("mid");
		List<Meeting> meetings=null;
		try {
			 conferenceServices.deleteMeetingById(mid);
             meetings=conferenceServices.getAllMeetings();
	    }catch(Exception e){
	    		System.out.println(e);
	    		request.setAttribute("flag","deleteFail");
	    		return "forward:/Meeting.jsp";
	    }
	    request.setAttribute("meetings",meetings);
		request.setAttribute("flag","deleteSuccess");
		return "forward:/Meeting.jsp";
	}
	@RequestMapping(value="/getMeetingStatistical.do")
	public String getMeetingStatistical(HttpServletRequest request,HttpServletResponse response){

		try {
			List<MeetingStatistical> meetingHold=conferenceServices.getMeetingHold();
			List<MeetingStatistical> meeetingUnHold=conferenceServices.getMeetingUnHold();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("统计会议出错");
		}

		return "";
	}
}
