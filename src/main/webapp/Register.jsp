<%@page import="java.io.PrintWriter"%>
<%@page import="javax.swing.text.Document"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- BOOTSTRAP CORE STYLE  -->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="css/register.css" rel="stylesheet" />
    
    
    <script type="text/javascript">
	function myReload() {
		document.getElementById("CreateCheckCode").src = document
				.getElementById("CreateCheckCode").src
				+ "?nocache=" + new Date().getTime();
				//window.location.reload();
	}
	</script>
	
  </head>
  
  <body>
    <%
    	String flag = (String)request.getAttribute("flag");
    	PrintWriter pw = response.getWriter();
		if (flag!=null && flag=="codeError") {
			pw.print("<script>alert('验证码错误！')</script>");
		}else if(flag=="namexist"){
			pw.print("<script>alert('用户名已存在！')</script>");
		} if(flag=="registerfail"){
			pw.print("<script>alert('注册失败！')</script>");
		}
    %>
	<div class="content-wrapper">
        <div class="container">
        	<div class="row pad-botm">
            	<div class="col-md-12">
                	<h1 class="header-line">用户注册</h1>
                </div>
			</div>
			
            <div class="row">
            	<div class="col-md-6 col-sm-6 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                           	注册
                        </div>
                        <div class="panel-body">
                            <form action="Register.do" name="register-form" id="register-form" method="POST">
	                            <div class="form-group">
	                                <label>用户名</label>
	                                <input id="username" name="name" class="form-control" type="text" />
	                            </div>
                                <div class="form-group">
                                	<label>密码</label>
                    	<input id="password" class="form-control" type="password" name="password"/>
	                            </div>
	                         	<div class="form-group">
	                              	<label>确认密码</label>
	                                <input id="re-password" class="form-control"  type="password" />
	                            </div>
	                            <div class="form-group">
	                                <label>验证码</label>
	                                <input id="checkCode" class="form-control" name="checkCode" type="text" />  
				            		<img src="getImage.do" id="CreateCheckCode" align="middle">
				            		<a onclick="myReload()"> 看不清,换一个</a>
	                            </div>   
                                <button type="submit" class="btn btn-danger">注册</button>
                                <span style="float:right">已经有帐号？请<a href="Login.jsp">登录</a></span>
                                <p class="help-block" id="textfield"></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
	
	<script src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(".btn-danger").click(function () {
		if ($("#username").val() == "") {
            $("#textfield").text("用户名不能为空！");
            return false;
        }
		var re = /^[\u4e00-\u9fa5]+$/;
		if (re.test($("#username").val())){
			$("#textfield").text("用户名不能有中文！");
			return false;
		}
		if ($("#password").val() == "") {
            $("#textfield").text("密码不能为空！");
            return false;
        }
		if ($("#password").val() != $("#re-password").val()) {
            $("#textfield").text("两次输入密码不同！");
            return false;
        }
		if ($("#checkCode").val() == "") {
            $("#textfield").text("请输入验证码！");
            return false;
        }
	});
	</script>
  </body>
</html>
