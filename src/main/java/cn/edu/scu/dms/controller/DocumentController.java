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

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.model.Qpwj;
import cn.edu.scu.dms.model.Swwj;
import cn.edu.scu.dms.services.FileOfApplyingServices;
import cn.edu.scu.dms.services.FileOfInstructionsServices;
import cn.edu.scu.dms.services.FileOfReceivingServices;

@Controller
@RequestMapping(value="/DocumentManaging")
public class DocumentController {
	
	//批示文件
	@Autowired
	FileOfInstructionsServices fileOfInstructions;
	//收文登记文件
	@Autowired
	FileOfReceivingServices fileOfReceiving;
	//报批示文件
	@Autowired
    FileOfApplyingServices fileOfApplyingServices;
	
	//批示文件操作对应的Conroller
	@RequestMapping(value="/registerFileOfInstructions.do")
	public String registerFileOfInstructions(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Pswj file=new Pswj();
		
		String timeString=request.getParameter("rectime");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		System.out.println("登记开始");
		
		NumberFormat numberformat1 = NumberFormat.getNumberInstance();    
		numberformat1.setGroupingUsed(false);
		numberformat1.setMinimumIntegerDigits(7);
		
		NumberFormat numberformat2 = NumberFormat.getNumberInstance(); 
		numberformat2.setGroupingUsed(false);
		numberformat2.setMinimumIntegerDigits(3);
		
		
		String pid=null;
		Pswj isExist=null;
		Random ranInt=new Random();
		
		do{
			pid="P-" + numberformat1.format(ranInt.nextInt(1000000))+numberformat2.format(ranInt.nextInt(100));
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
        	request.setAttribute("flag","registerFail");
			return "forward:/Document1-Add.jsp";
		}
        
        List<Pswj> files=null;
        try {
			files=fileOfInstructions.getAllFile();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");	
		}
		request.setAttribute("flag","registerSuccess");
		request.setAttribute("files",files);
		return "forward:/Document1.jsp";
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
	
	@RequestMapping(value="/updateFileofInstructions.do")
	public  String updateFileofInstructions(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		System.out.println("更新开始");

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String pid=request.getParameter("pid");

		Pswj file=new Pswj();
		
		String timeString=request.getParameter("rectime");
		System.out.println(timeString+"hh");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		
		Pswj isExist=null;
        
	    isExist=fileOfInstructions.getPswjById(pid);
	    if(isExist==null)
	    {
	    	request.setAttribute("flag", "modifyFail");
	    	return "forward:/Document1-Modify.jsp";
	    }
		
		Date rectime =  formatter.parse(timeString);
		String numbers=request.getParameter("numbers");
		String title=request.getParameter("title");
		System.out.println(title);
		String spishi=request.getParameter("spishi");
        String wpishi=request.getParameter("wpishi");
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date deadline=formatter.parse(request.getParameter("deadline"));
        String isdone=request.getParameter("isdone");
        String phone=request.getParameter("phone");
        String direction=request.getParameter("direction");

		//title = CharacTool.encoding(title);
        
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
        	fileOfInstructions.update(file);
		} catch (Exception e) {
			request.setAttribute("flag", "modifyFail");
		}
        
        List<Pswj> files=null;
        try {
			files=fileOfInstructions.getAllFile();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");	
		}
		request.setAttribute("flag", "modifySuccess");
		request.setAttribute("files",files);
		return "forward:/Document1.jsp";
	}
    @RequestMapping(value="/getFileOfInstructionsById.do")
	public String getFileOfInstructionsById(HttpServletRequest request,HttpServletResponse response){
		String pid=request.getParameter("pid");
		String jsp=request.getParameter("jsp");
		Pswj pswj=fileOfInstructions.getPswjById(pid);
		request.setAttribute("file",pswj);
		return "forward:/"+jsp;
		
	}
    @RequestMapping(value="/deleteFileOfInstructionById.do")
    public String deleteFileOfInstructionById(HttpServletRequest request,HttpServletResponse response){
    	
    	String id=request.getParameter("id");
    	List<Pswj> files=null;
    	try {
    	 fileOfInstructions.deleteFile(id);
         files=fileOfInstructions.getAllFile();
    	}catch(Exception e){
    		System.out.println(e);
    		request.setAttribute("flag","deleteFail");
    		return "forward:/Document1.jsp";
    	}
    	request.setAttribute("files",files);
		request.setAttribute("flag","deleteSuccess");
		return "forward:/Document1.jsp";
	}
    
	//收文登记文件对应的Controller
	@RequestMapping(value="/registerFileOfReceiving.do")
	public String registerFileOfReceiving(HttpServletRequest request,HttpServletResponse response) throws ParseException{

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Swwj swwj=new Swwj();
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		
		NumberFormat numberformat1 = NumberFormat.getNumberInstance();  
		numberformat1.setGroupingUsed(false);
		numberformat1.setMinimumIntegerDigits(7);
		
		NumberFormat numberformat2 = NumberFormat.getNumberInstance();   
		numberformat1.setGroupingUsed(false);
		numberformat2.setMinimumIntegerDigits(3);
		
		
		System.out.println("收文登记开始");
		String sid=null;
		Swwj isExist=null;
		Random ranInt=new Random();
		
		do{
			sid="S-" + numberformat1.format(ranInt.nextInt(1000000))+numberformat2.format(ranInt.nextInt(100));
			isExist=fileOfReceiving.getSwwjById(sid);
		}while(isExist!=null);
		
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
	    	 fileOfReceiving.registerFile(swwj);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("flag","registerFail");
			return "forward:/Document2-Add.jsp";
		}

		List<Swwj> files=null;
		try {
			files=fileOfReceiving.getAllFile();
		} catch (Exception e) {
			System.out.println("获取批示文件出错");
		}
		request.setAttribute("flag","registerSuccess");
		request.setAttribute("files",files);
		return "forward:/Document2.jsp";
	}
	@RequestMapping(value="/getFilesOfReceiving.do")
	public String getFilesOfReceiving(HttpServletRequest request,HttpServletResponse response){
		
		List<Swwj> temp=null;
		
		try {
			temp =fileOfReceiving.getAllFile();
			request.setAttribute("files",temp);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取文件出错");
		}
		return "forward:/Document2.jsp";
	}
	@RequestMapping(value="/getFileOfReceivingById.do")
	public String getFileOfReceivingById(HttpServletRequest request,HttpServletResponse response){
		String sid=request.getParameter("sid");
		System.out.print(sid);
		String jsp=request.getParameter("jsp");
		System.out.println(jsp);
		Swwj swwj=fileOfReceiving.getSwwjById(sid);

		request.setAttribute("file",swwj);
		return "forward:/"+jsp;

	}
	@RequestMapping(value="/updateFileofReceiving.do")
	public  String updateFileofReceiving(HttpServletRequest request,HttpServletResponse response) throws ParseException{

		System.out.println("更新开始");

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sid=request.getParameter("sid");

		Swwj file=new Swwj();

		String timeString=request.getParameter("time1");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		String timeString2=request.getParameter("dotime");

		Swwj isExist=null;

		isExist=fileOfReceiving.getSwwjById(sid);
		if(isExist==null)
		{
			request.setAttribute("flag","modifyFail");
			return "forward:/Document2-Modify.jsp";
		}


		Date time1 =  formatter.parse(timeString);
		String department=request.getParameter("department");
		String number1=request.getParameter("number1");
		String title=request.getParameter("title");
		Date dotime=formatter.parse(timeString2);
		String wpishi=request.getParameter("wpishi");
		String direction=request.getParameter("direction");

		file.setSid(sid);
		file.setTime1(time1);
		file.setDepartment(department);
		file.setNumber1(number1);
		file.setTitle(title);
		file.setDotime(dotime);
		file.setWpishi(wpishi);
		file.setDirection(direction);

		try {
			fileOfReceiving.update(file);
		} catch (Exception e) {
			request.setAttribute("flag","modifyFail");
		}

		List<Swwj> files=null;
		try {
			files=fileOfReceiving.getAllFile();
		} catch (Exception e) {
			System.out.println("获取收文文件出错");
		}
		request.setAttribute("flag","modifySuccess");
		request.setAttribute("files",files);
		return "forward:/Document2.jsp";
	}
    @RequestMapping(value="/deleteFileOfReceivingById.do")
	public String deleteFileOfReceivingById(HttpServletRequest request,HttpServletResponse response){
    	
    	String id=request.getParameter("id");
    	List<Swwj> files=null;
    	try {
    	 fileOfReceiving.deleteFile(id);
         files= fileOfReceiving.getAllFile();
    	}catch(Exception e){
    		System.out.println(e);
    		request.setAttribute("flag","deleteFail");
    		return "forward:/Document2.jsp";
    	}
    	request.setAttribute("files",files);
		request.setAttribute("flag","deleteSuccess");
		return "forward:/Document2.jsp";
	}
    
	//报签批文件对应的Controller
	@RequestMapping(value="/registerFileOfApplying.do")
	public String registerFileOfApplying(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Qpwj qpwj=new Qpwj();
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
		
		NumberFormat numberformat1 = NumberFormat.getNumberInstance();   
		numberformat1.setGroupingUsed(false);
		numberformat1.setMinimumIntegerDigits(7);
		NumberFormat numberformat2 = NumberFormat.getNumberInstance();   
		numberformat2.setGroupingUsed(false);
		numberformat2.setMinimumIntegerDigits(3);
		
		String qpid=null;
		Pswj isExist=null;
		Random ranInt=new Random();
		
		do{
			qpid="Q-" + numberformat1.format(ranInt.nextInt(1000000))+numberformat2.format(ranInt.nextInt(100));
			isExist=fileOfInstructions.getPswjById(qpid);
		}while(isExist!=null);
		
		
        Date qptime=formatter.parse(request.getParameter("qptime"));
		String title=request.getParameter("title");
		formatter = new SimpleDateFormat( "yyyy-MM-dd"); 
        Date attribute=formatter.parse(request.getParameter("attribute"));
        String leaderName=request.getParameter("leaderName");
        String zpishi=request.getParameter("zpishi");
        String direction=request.getParameter("direction");
        String note=request.getParameter("note");
        
        qpwj.setQpid(qpid);
        qpwj.setQptime(qptime);
        qpwj.setTitle(title);
        qpwj.setAttribute(attribute);
        qpwj.setLeadername(leaderName);
        qpwj.setZpishi(zpishi);
        qpwj.setDirection(direction);
        qpwj.setNote(note);
        try {
		   fileOfApplyingServices.registerFile(qpwj);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("flag","registerFail");
			System.out.println("包批示文件登记出错");
			return "forward:/Document3-Add.jsp";
		}
        List<Qpwj> files=null;
        try {
			files= fileOfApplyingServices.getAllFile();
		} catch (Exception e) {
		   System.out.println("获取批示文件出错");	
		}
		request.setAttribute("files",files);
		request.setAttribute("flag","registerSuccess");
		return "forward:/Document3.jsp";
	}
	@RequestMapping(value="/getFileOfApplying.do")
	public String getFileOfApplying(HttpServletRequest request,HttpServletResponse response){
		List<Qpwj> files=null;
		try {
			files= fileOfApplyingServices.getAllFile();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取签批文件出错");
		}
		request.setAttribute("files", files);
		return "forward:/Document3.jsp";
	}
	
   @RequestMapping(value="/deleteFileOfApplyingById.do")
   public String deleteFileOfApplyingById(HttpServletRequest request,HttpServletResponse response){
    	
    	String id=request.getParameter("id");
    	List<Qpwj> files=null;
    	try {
    	 fileOfApplyingServices.deleteFile(id);
         files= fileOfApplyingServices.getAllFile();
    	}catch(Exception e){
    		System.out.println(e);
    		request.setAttribute("flag","deleteFail");
    		return "forward:/Document3.jsp";
    	}
    	request.setAttribute("files",files);
	   request.setAttribute("flag","deleteSuccessS");
		return "forward:/Document3.jsp";
	}
	
	
}
