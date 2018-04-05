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
	  <link rel="stylesheet" type="text/css" href="css/mdialog.css">
    
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
    <%--<%
    	String flag = (String)request.getAttribute("flag");
    	PrintWriter pw = response.getWriter();
		if (flag!=null && flag=="codeError") {
			pw.print("<script>alert('验证码错误！')</script>");
		}else if(flag=="nameExist"){
			pw.print("<script>alert('用户名已存在！')</script>");
		} if(flag=="registerfail"){
			pw.print("<script>alert('注册失败！')</script>");
		}
    %>--%>
	<script type="text/javascript" src="js/zepto.min.js"></script>
	<script type="text/javascript" src="js/mdialog.js"></script>
	<script type="text/javascript">
		var flag = '<%=request.getAttribute("flag")%>';
        if (flag == 'codeError'){
            new TipBox({type:'error',str:'验证码错误！',setTime:1500});
        } else if (flag == 'nameExist') {
            new TipBox({type:'error',str:'用户名已存在！',hasBtn:true});
		} else if (flag == 'registerfail') {
            new TipBox({type:'error',str:'注册失败！',hasBtn:true});
        }
	</script>
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
                            <form action="/account/Register.do" name="register-form" id="register-form" method="post">
	                            <div class="form-group">
	                                <label>用户名</label>
	                                <input id="username" name="name" class="form-control" type="text" onblur="checkName()"/>
									<p class="help-block" id="textfield-name"></p>
	                            </div>
                                <div class="form-group">
                                	<label>密码</label>
                    				<input id="password" class="form-control" type="password" name="password" onblur="checkPassword()"/>
									<p class="help-block" id="textfield-password"></p>
	                            </div>
	                         	<div class="form-group">
	                              	<label>确认密码</label>
	                                <input id="re-password" class="form-control"  type="password" onblur="checkRePassword()"/>
									<p class="help-block" id="textfield-repassword"></p>
	                            </div>
								<div class="form-group">
									<label>昵称</label>
									<input id="nickname" name="nickname" class="form-control" type="text" onblur="checkNickName()"/>
									<p class="help-block" id="textfield-nickname"></p>
								</div>
								<div class="form-group">
									<label>邮箱</label>
									<input id="email" name="email" class="form-control" type="text" onblur="checkEmail()"/>
									<p class="help-block" id="textfield-email"></p>
								</div>
								<div class="form-group">
									<label>手机号码</label>
									<input id="phone-number" name="phoneNumber" class="form-control" type="text" onblur="checkPhone()"/>
									<p class="help-block" id="textfield-phone"></p>
								</div>
	                            <div class="form-group">
	                                <label>验证码</label>
	                                <input id="checkCode" class="form-control" name="checkCode" type="text" onblur="check_Code()"/>
				            		<img src="/account/getImage.do" id="CreateCheckCode" align="middle">
				            		<a onclick="myReload()"> 看不清,换一个</a>
									<p class="help-block" id="textfield-checkCode"></p>
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
		if (
		checkName() &&
		checkPassword() &&
		checkRePassword() &&
		checkNickName() &&
		checkEmail() &&
		checkPhone() &&
		check_Code()
		)
        	return true;
		return false;
	});

    function checkName() {
        if ($("#username").val() == "") {
            $("#textfield-name").text("用户名不能为空！");
            return false;
        }
        var reg_user = /^[A-Za-z0-9]+$/;
        if (!reg_user.test($("#username").val())){
            $("#textfield-name").text("用户名不合法！");
            return false;
        }

        var name = document.getElementById("username").value;
        var xmlhttp;
        if(window.XMLHttpRequest){
            //针对FireFox,Mozillar,Opera,Safari,IE7,IE8
            xmlhttp = new XMLHttpRequest();

            //对某些特定版本的mozillar浏览器的bug进行修正
            if(xmlhttp.overrideMineType){
                xmlhttp.overrideMineType("text/xml");
            }
        }else if(window.ActiveXObject){
            //针对IE5，IE5.5，IE6

            //两个可以用于创建XMLHTTPRequest对象的控件名称。保存在一个JS数组中。
            var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
            for(var i = 0; i<activeName.length; i++){
                //取出一个控件名进行创建，如果成功就终止循环
                try{
                    xmlhttp = new ActiveXObject(activexName[i]);
                    break;
                }catch(e){}
            }
        }

        xmlhttp.onreadystatechange = function() {
            //判断对象的状态是否交互完成
            if(xmlhttp.readyState == 4){

                //判断http的交互是否成功
                if(xmlhttp.status == 200){

                    //获取服务器端返回的数据（文本）
                    var responseText = xmlhttp.responseText;

                    //将数据显示在页面上
                    var divNode = document.getElementById("textfield-name");
                    divNode.innerHTML = responseText;
                    if (responseText == null || responseText == "")
                        return true;
					else
                        return false;
                }
            }
		}
        //设置连接信息(请求方式，请求的url,true表示异步方式交互)
        xmlhttp.open("GET","/account/checkRegister.do?name=" + name, true);

        //发送数据，开始和服务器进行交互。
        xmlhttp.send(null);

        //$("#textfield-name").text("");
        var text = document.getElementById("textfield-name");
        if (text.innerHTML == "")
        	return true;
        else
            return false;
    }

    function checkPassword() {
        if ($("#password").val() == "") {
            $("#textfield-password").text("密码不能为空！");
            return false;
        }
        $("#textfield-password").text("");
        return true;
    }

    function checkRePassword() {
        if ($("#password").val() != $("#re-password").val()) {
            $("#textfield-repassword").text("两次输入密码不同！");
            return false;
        }
        $("#textfield-repassword").text("");
        return true;
    }

    function checkNickName() {
        if ($("#nickname").val() == "") {
            $("#textfield-nickname").text("昵称不能为空！");
            return false;
        }
        $("#textfield-nickname").text("");
        return true;
    }

    function checkEmail() {
        if ($("#email").val() == "") {
            $("#textfield-email").text("邮箱不能为空！");
            return false;
        }
        var reg_email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!reg_email.test($("#email").val())){
            $("#textfield-email").text("邮箱不合法！");
            return false;
        }
        $("#textfield-email").text("");
        return true;
    }

    function checkPhone() {
        if ($("#phone-number").val() == "") {
            $("#textfield-phone").text("手机号码不能为空！");
            return false;
        }
        var reg_phone=/^1[3,5,7,8]\d{9}$/;
        if (!reg_phone.test($("#phone-number").val())){
            $("#textfield-phone").text("手机号码不合法！");
            return false;
        }
        $("#textfield-phone").text("");
        return true;
    }

    function check_Code() {
        if ($("#checkCode").val() == "" || $("#checkCode").val() == null) {
            $("#textfield-checkCode").text("请输入验证码！");
            return false;
        }
        $("#textfield-checkCode").text("");
        return true;
    }

	</script>
  </body>
</html>
