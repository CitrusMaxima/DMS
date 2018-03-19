package cn.edu.scu.dms.controller;

import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.model.Qpwj;
import cn.edu.scu.dms.model.Swwj;
import cn.edu.scu.dms.services.AccountServices;
import cn.edu.scu.dms.services.FileOfApplying;
import cn.edu.scu.dms.services.FileOfInstructionsServices;
import cn.edu.scu.dms.services.FileOfRecevingServices;

@Controller
@RequestMapping(value="/DocumentManaging")
public class DocumentController {
	
	//批示文件
	@Autowired
	FileOfInstructionsServices fileOfInstructions;
	//收文登记文件
	//@Autowired
	FileOfRecevingServices fileOfReceving;
	//报批示文件
	//@Autowired
    FileOfApplying fileOfApplying;
	
	//批示文件操作对应的Conroller
	@RequestMapping(value="/registerFileOfInstructions.do")
	public String registerFileOfInstructions(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		Pswj file=new Pswj();
		
		String timeString=request.getParameter("rectime");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		System.out.println("登记开始");
		String pid=null;
		Pswj isExist=null;
		Random ranInt=new Random();
		
		do{
			pid=ranInt.nextInt(100000)+""+ranInt.nextInt(100);
			isExist=fileOfInstructions.getPswjById(pid);
		}while(isExist!=null);

		
		Date rectime =  formatter.parse(timeString);
		String numbers=request.getParameter("numbers");
		String title=request.getParameter("title");
		String spishi=request.getParameter("spishi");
        String wpishi=request.getParameter("wpishi");
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date deadline=formatter.parse(request.getParameter("deadline"));
        String isdone=request.getParameter("isdone");
        String phone=request.getParameter("phone");
        String direction=request.getParameter("direction");
        
        file.setPid(pid);
        file.setRectime(rectime);
        file.setNumbers(numbers);
        file.setTitle(title);
        file.setSpishi(spishi);
        file.setWpishi(wpishi);
        file.setDeadline(deadline);
        file.setIsdone(isdone);
        file.setPhone(phone);
        file.setDirection(direction);
        
        try {
        	 fileOfInstructions.registerFile(file);
		} catch (Exception e) {
			 request.setAttribute("flag","fail");
			return "forward:/Document1-Add.jsp";
		}
		request.setAttribute("flag","success");
		return "forward:/Document1-Add.jsp";
	}

	@RequestMapping(value="/getFiles.do")
	public String getFilesOfInstructions(HttpServletRequest request,HttpServletResponse response){
		List<Pswj> files=null;
		System.out.print("获取文件");
		try {
			files=fileOfInstructions.getAllFile();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");	
		}
		request.setAttribute("files", files);
		return "forward:/Document1.jsp";
	}
	@RequestMapping(value="/deleteFile.do")
	public String deleteFileOfInstructions(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("pid");
		try {
			fileOfInstructions.deleteFile(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
	
	//收文登记文件对应的Controller
	@RequestMapping(value="/registerFileOfReceving.do")
	public String registerFileOfReceving(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		Swwj swwj=null;
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		
		String sid=request.getParameter("sid");
	    Date time1=formatter.parse(request.getParameter("time1"));
	    String department=request.getParameter("department");
	    String number1=request.getParameter("number1");
        String title=request.getParameter("title");
        Date dotime=formatter.parse(request.getParameter("dotime"));
        String wpishi=request.getParameter("wpishi");
	    String direction=request.getParameter("direction");
		
	    swwj.setSid(sid);
	    swwj.setTime1(time1);
	    swwj.setDepartment(department);
	    swwj.setNumber1(number1);
	    swwj.setTitle(title);
	    swwj.setDotime(dotime);
	    swwj.setWpishi(wpishi);
	    swwj.setDirection(direction);
	    
	    try {
	    	 fileOfReceving.registerFile(swwj);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	@RequestMapping(value="/getFilesOfReceving.do")
	public String getFilesOfReceving(HttpServletRequest request,HttpServletResponse response){
		
		List<Swwj> temp=null;
		
		try {
			temp =fileOfReceving.getAllFile();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
	//报批示文件对应的Controller
	@RequestMapping(value="/registerFileOfApplying.do")
	public String registerFileOfApplying(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		Qpwj qpwj=null;
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		
		String qpid=request.getParameter("qid");
        Date qptime=formatter.parse(request.getParameter("qptime"));
		String title=request.getParameter("title");
		formatter = new SimpleDateFormat( "yyyy-MM-dd"); 
        Date attribute=formatter.parse(request.getParameter("attribute"));
        String leaderName=request.getParameter("leaderName");
        String zpishi=request.getParameter("zpishi");
        String direction=request.getParameter("direcion");
        String note=request.getParameter("note");
        
        qpwj.setQpid(qpid);
        qpwj.setQptime(qptime);
        qpwj.setTitle(title);
        qpwj.setAttribute(attribute);
        qpwj.setLeaderName(leaderName);
        qpwj.setZpishi(zpishi);
        qpwj.setDirection(direction);
        qpwj.setNote(note);
        try {
		   fileOfApplying.registerFile(qpwj);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		return "";
	}
	@RequestMapping(value="/getFileOfApplying.do")
	public String getFileOfApplying(HttpServletRequest request,HttpServletResponse response){
		List<Qpwj> temp=null;
		
		try {
			temp=fileOfApplying.getAllFile();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
}
