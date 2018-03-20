<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登陆文档管理系统！</title>
	
	<link rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="css/bootstrap-2.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="css/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/cssCharts.css">

  </head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="Welcome.jsp">
                	<i class="large material-icons">track_changes</i> 
                	<strong>文档管理系统</strong>
                </a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right">
				<li>
					<a class="dropdown-button waves-effect waves-dark" data-activates="dropdown1">
						<i class="fa fa-user fa-fw"></i> 
						<b>杨旭</b> 
						<i class="material-icons right">arrow_drop_down</i>
					</a>
				</li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
		<ul id="dropdown1" class="dropdown-content">
			<li>
				<a href="PersonalCenter.jsp"><i class="fa fa-user fa-fw"></i> 个人中心</a>
			</li>
            <li>
                <a href="ModifyPassword.jsp"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
            </li>
			<li>
				<a href="Login.jsp"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
			</li>
		</ul>

        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a href="#" class="active-menu waves-effect waves-dark"><i class="fa fa-sitemap"></i> 文档管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">领导批示文件表<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="Document1-Add.jsp">登记</a>
                                    </li>
                                    <li>
                                        <a href="">查询</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">收文登记表<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="Document2-Add.jsp">登记</a>
                                    </li>
                                    <li>
                                        <a href="Document2.jsp">查询</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">报主要领导签批文件登记表<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="Document3-Add.jsp">登记</a>
                                    </li>
                                    <li>
                                        <a href="Document3.jsp">查询</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="form.html" class="waves-effect waves-dark"><i class="fa fa-edit"></i> 会议管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="Meeting-Add.jsp">登记</a>
                            </li>
                            <li>
                                <a href="Meeting.jsp">会议查询</a>
                            </li>
                            <li>
                                <a href="Meeting-Statistics.jsp">会议统计</a>
                            </li>
                        </ul>
                    </li>
                    <li id="admin">
                        <a href="form.html" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> 用户管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="User-Add.jsp">添加用户</a>
                            </li>
                            <li>
                                <a href="User.jsp">用户查询</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                    领导批示文件表
                </h1>
                <ol class="breadcrumb">
                    <li><a>文档管理系统</a></li>
                    <li><a>领导批示文件表</a></li>
                    <li class="active">查询</li>
                </ol>

            </div>

            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="card">
                            <div class="card-action">
                                领导批示文件表
                            </div>
                            <div class="card-content">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th class="center">编号</th>
                                            <th class="center">收文时间</th>
                                            <th class="center">来文标题</th>
                                            <th class="center">字号</th>
                                            <th class="center">省领导批示</th>
                                            <th class="center">委领导批示</th>
                                            <th class="center">时限</th>
                                            <th class="center">办理情况</th>
                                            <th class="center">承办处电话</th>
                                            <th class="center">流向</th>
                                            <th class="center">删除</th>
                                        </tr>
                                        </thead> 
											    <tbody>
											     <c:forEach items="${files}"  var="pswj">  
											    <tr>
												    <td class="center modify">${pswj.pid}</td>
												    <td class="center modify time"> <fmt:formatDate value="${pswj.rectime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												    <td class="center modify">${pswj.title}</td>
												    <td class="center modify">${pswj.numbers}</td>
												    <td class="center modify">${pswj.spishi}</td>
												    <td class="center modify">${pswj.wpishi}</td>
												    <td class="center modify time"><fmt:formatDate value="${pswj.deadline}" pattern="yyyy-MM-dd"/></td>
												    <td class="center modify">${pswj.isdone}</td>
												    <td class="center modify">${pswj.phone}</td>
												    <td class="center modify">${pswj.direction}</td>
												    <td class="center">
												    <button class="btn btn-danger" >删除</button></td>
											    </tr>
											  </c:forEach> 
											    </tbody>
									
                                    </table>
                                </div>

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>


    <!-- jQuery Js -->
    <script src="js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
	
	<script src="js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="js/raphael-2.1.0.min.js"></script>
    <script src="js/morris.js"></script>
	
	
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	
	 <script src="js/jquery.chart.js"></script>
	 <!-- DATA TABLE SCRIPTS -->
    <script src="js/jquery.dataTables.js"></script>
    <script src="js/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
    <!-- Custom Js -->
    <script src="js/custom-scripts.js"></script>
    <script type="text/javascript">
        var power = '<%=request.getSession().getAttribute("power")%>' ;
        var admin = document.getElementById("admin");
        if (power == "0")
            admin.style.display="none";
        $(".modify").click(function() {
        	
        	document.write("<form action=/DocumentManagingupdateFileofInstructions.do method=post name=formx1 style='display:none'>");
        	document.write("<input type=hidden name=pid value='"+username+"'");
        	document.write("</form>");
        	document.formx1.submit();
        });
    </script>
    </div>
</body>
</html>
