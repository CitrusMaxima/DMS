<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                    <b><%=request.getSession().getAttribute("name")%></b>
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
                <li class="active">修改</li>
            </ol>

        </div>

        <div id="page-inner">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-action">
                            收文登记表
                        </div>
                        <div class="card-content">
                            <form class="col s12" action="DocumentManaging/updateFileofInstructions.do" id="fileform1" method="POST">
                                <input name="pid" type="hidden" value="${file.pid}">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="title" type="text" class="validate" name="title" value="${file.title}">
                                        <label class="active" for="title">来文标题</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input id="rectime" name="rectime" type="text" class="Wdate validate" value="<fmt:formatDate value='${file.rectime }' pattern='yyyy-MM-dd HH:mm:ss' />"  onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'deadline\')||\'new Date()\'}'})"/>
                                        <label class="active" for="rectime">收文时间</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="deadline" name="deadline" type="text" value="<fmt:formatDate value='${file.deadline }' pattern='yyyy-MM-dd' />"  class="Wdate validate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'rectime\')}'})"/>
                                        <label class="active" for="deadline">时限</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="numbers" name="numbers" type="text" class="validate" value="${file.numbers}">
                                        <label class="active" for="numbers">字号</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="Spishi" name="spishi" type="text" class="validate" value="${file.spishi}">
                                        <label class="active" for="Spishi">省领导批示</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="Wpishi" name="wpishi"type="text" class="validate"value="${file.wpishi}">
                                        <label class="active" for="Wpishi">委领导批示</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <input id="IsDone" name="isdone" type="text" class="validate"value="${file.isdone}">
                                        <label class="active" for="IsDone">办理情况</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="phone" name="phone" type="text" class="validate"value="${file.phone}">
                                        <label class="active" for="phone">承办处电话</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <input id="direction" name="direction" type="text" class="validate"value="${file.direction}">
                                        <label class="active" for="direction">流向</label>
                                    </div>
                                </div>
                            </form>
                            <a class="waves-effect waves-light btn-large" id="modify">修改</a>
                            <a disabled class="waves-effect waves-light btn-large" id="save" onclick="document.getElementById('fileform1').submit();">保存</a>
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
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script>
    $(document).ready(function () {
        $(".validate").attr("disabled", true);
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
        $(".validate").attr("disabled", true);
        $("#save").attr("disabled", true);
        $("#modify").attr("disabled", false);
        return true;
    });
</script>
<script type="text/javascript">
    var power = '<%=request.getSession().getAttribute("power")%>' ;
    var admin = document.getElementById("admin");
    if (power == "0")
        admin.style.display="none";
    //document.getElementsByClassName("validate").disabled=true;
    $("#modify").click(function () {
        $(".validate").attr("disabled", false);
        $("#save").attr("disabled", false);
        $("#modify").attr("disabled", true);
    });
</script>
</body>
</html>
