<%@page import="java.awt.Window"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <script>

       var flag = '${flag}';
		if (flag=="exist") {
			alert('文件编号已存在！');
			window.location.href="DocumentManaging/getFiles.do";
		}else if(flag=="success"){
			alert('登记成功！');
			window.location.href="DocumentManaging/getFiles.do";
		} else if(flag=="fail"){
			alert('登记失败失败！');
		}
       
 </script>
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
                                    <a href="Document1-Add.jsp" >登记</a>
                                </li>
                                <li>
                                    <a href="/DocumentManaging/getFiles.do">查询</a>
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
                                    <a href="/DocumentManaging/getFilesOfReceiving.do">查询</a>
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
                <li class="active">登记</li>
            </ol>

        </div>

        <div id="page-inner">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-action">
                            收文登记表
                        </div>
                        <div class="card-content" >
                            <form class="col s12" action="DocumentManaging/registerFileOfInstructions.do" id="fileform">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="title" type="text" class="validate" name="title">
                                        <label for="title">来文标题</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input id="rectime" name="rectime" type="text" class="Wdate validate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'deadline\')||\'new Date()\'}'})"/>
                                        <label for="rectime">收文时间</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="deadline" type="text" name="deadline" class="Wdate validate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'rectime\')}'})"/>
                                        <label for="deadline">时限</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="numbers" name="numbers" type="text" class="validate" >
                                        <label for="numbers">字号</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="Spishi"  name="spishi" type="text" class="validate" >
                                        <label for="Spishi">省领导批示</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="Wpishi" type="text" name="wpishi" class="validate">
                                        <label for="Wpishi">委领导批示</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input id="IsDone" type="text" name="isdone" class="validate">
                                        <label for="IsDone">办理情况</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="phone" type="text" name="phone" class="validate">
                                        <label for="phone">承办处电话</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="direction" type="text" name="direction" class="validate">
                                        <label for="direction">流向</label>
                                    </div>
                                </div>
                            </form>
                            <a  class="waves-effect waves-light btn-large" id="save" onclick="document.getElementById('fileform').submit();">保存</a>
                            <div id="textfield"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
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
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- Custom Js -->
<script src="js/custom-scripts.js"></script>

<script type="text/javascript">
    $("#save").click(function () {
        if ($("#title").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("来文标题不能为空！");
            return false;
        }
        if ($("#rectime").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("收文时间不能为空！");
            return false;
        }
        if ($("#deadline").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("时限不能为空！");
            return false;
        }
        if ($("#numbers").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("字号不能为空！");
            return false;
        }
        if ($("#Spishi").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("省领导批示不能为空！");
            return false;
        }
        if ($("#Wpishi").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("委领导批示不能为空！");
            return false;
        }
        if ($("#IsDone").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("办理情况不能为空！");
            return false;
        }
        if ($("#phone").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("承办处电话不能为空！");
            return false;
        }
        if ($("#direction").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("流向不能为空！");
            return false;
        }
        $("#textfield").removeClass("alert alert-warning");
        $("#textfield").text("");
        return true;
    });
</script>
<script type="text/javascript">
    var power = '<%=request.getSession().getAttribute("power")%>' ;
    var admin = document.getElementById("admin");
    if (power == "0")
        admin.style.display="none";
</script>
</body>
</html>
