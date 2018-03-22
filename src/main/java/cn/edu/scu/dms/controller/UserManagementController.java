package cn.edu.scu.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;
import java.util.List;

import cn.edu.scu.dms.model.User;
import cn.edu.scu.dms.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value="/user")
public class UserManagementController {

	//用户
	@Autowired
	AccountServices account;
	
	@RequestMapping(value="/adduser.do")
	public  String addUser(HttpServletRequest request,HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		User user = new User();

		String uid = request.getParameter("uid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String ismanager = request.getParameter("ismanager");
		boolean isAdmin;
		if(ismanager == null) {
			isAdmin = false;
		} else {
			isAdmin = true;
		}

		user.setUid(uid);
		user.setPassword(password);
		user.setName(name);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setIsmanager(isAdmin);

		try {
			int returnResult = account.insertUser(user);
			if (returnResult == 0){
				request.setAttribute("flag", "nameExist");
				return "forward:/User-Add.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("flag","registerFail");
			return "forward:/User-Add.jsp";
		}

		List<User> users = null;
		try {
			users=account.getAllUser();
		} catch (Exception e) {
			System.out.println("获取用户列表出错");
		}
		request.setAttribute("flag","registerSuccess");
		request.setAttribute("users",users);
		return "forward:/User.jsp";
	}
	@RequestMapping(value="/getuser.do")
	public  String getUser(HttpServletRequest request,HttpServletResponse response){
		List<User> users=null;

		System.out.print("获取用户");
		try {
			users=account.getAllUser();
		} catch (Exception e) {
			System.out.println("获取用户出错");
		}
		request.setAttribute("users", users);
		return "forward:/User.jsp";
		
	}
	@RequestMapping(value="/getUserById.do")
	public  String getUserById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("uid");
		User user = account.getUser(id);
		request.setAttribute("user",user);
		return "forward:/User-Modify.jsp";
	}
	@RequestMapping(value="/updateUser.do")
	public  String updateUser(HttpServletRequest request,HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String uid = request.getParameter("uid");
		User user = new User();
		User isExist=account.getUser(uid);
		if(isExist==null)
		{
			request.setAttribute("flag", "modifyFail");
			return "forward:/User-Modify.jsp";
		}

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String ismanager = request.getParameter("ismanager");
		boolean isAdmin;
		if(ismanager == null) {
			isAdmin = false;
		} else {
			isAdmin = true;
		}

		user.setUid(uid);
		user.setPassword(password);
		user.setName(name);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setIsmanager(isAdmin);

		try {
			account.update(user);
		} catch (Exception e) {
			request.setAttribute("flag", "modifyFail");
		}

		List<User> users=null;
		try {
			users=account.getAllUser();
		} catch (Exception e) {
			System.out.println("获取用户列表出错");
		}

		request.setAttribute("users",users);
		request.setAttribute("flag","modifySuccess");
		return "forward:/User.jsp";
	}
	@RequestMapping(value="/deleteUserById.do")
	public String deleteUserById(HttpServletRequest request,HttpServletResponse response){
		String uid = request.getParameter("uid");
		List<User> users=null;
		try {
			account.deleteUser(uid);
			users=account.getAllUser();
		}catch(Exception e){
			System.out.println(e);
			request.setAttribute("flag","deleteFail");
			return "forward:/User.jsp";
		}
		request.setAttribute("users",users);
		request.setAttribute("flag","deleteSuccess");
		return "forward:/User.jsp";
	}
}
