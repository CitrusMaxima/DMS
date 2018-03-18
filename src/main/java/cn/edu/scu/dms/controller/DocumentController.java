package cn.edu.scu.dms.controller;

import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.services.AccountServices;
import cn.edu.scu.dms.services.FileOfInstructionsServices;

@Controller
@RequestMapping(value="/DocumentManaging")
public class DocumentController {
	
	//批示文件
	@Autowired
	FileOfInstructionsServices fileOfInstructions;
	
	//批示文件操作对应的Conroller
	@RequestMapping(value="/registerFileOfInstructions.do")
	public String registerFileOfInstructions(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		Pswj file=new Pswj();
		
		String timeString=request.getParameter("rectime");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd "); 
		
		String pid= request.getParameter("pid");
		Date rectime =  formatter.parse(timeString);
		Integer numbers=Integer.valueOf(request.getParameter("numbers"));
		String title=request.getParameter("title");
		String spishi=request.getParameter("spishi");
        String wpishi=request.getParameter("wpishi");
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
			// TODO: handle exception
		}
		
		return "";
	}

	@RequestMapping(value="/getFiles.do")
	public String getFilesOfInstructions(HttpServletRequest request,HttpServletResponse response){
		
		List<Pswj> files=null;
		try {
			files=fileOfInstructions.getAllFile();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");	
		}
		
		request.setAttribute("files", files);
		return "";
		
	}
	
	
	//收文登记文件对应的Controller
	public String registerFileOfReceving(HttpServletRequest request,HttpServletResponse response){
		return "";
	}
	public String getFilesOfReceving(HttpServletRequest request,HttpServletResponse response){
		return "";
	}
	
	

}
