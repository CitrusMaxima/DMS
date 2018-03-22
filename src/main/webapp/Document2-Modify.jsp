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
    <link rel="stylesheet" type="text/css" href="css/mdialog.css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/cssCharts.css">

</head>

<body>
<script type="text/javascript" src="js/zepto.min.js"></script>
<script type="text/javascript" src="js/mdialog.js"></script>
<script type="text/javascript">
    var flag = '<%=request.getAttribute("flag")%>';
    if (flag == 'modifyFail'){
        new TipBox({type:'error',str:'修改失败',hasBtn:true});
    }
    var login = '<%=request.getSession().getAttribute("login")%>';
    if (login != 'success'){
        window.location.href="Login.jsp";
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
                    <b><%=request.getSession().getAttribute("name")%></b>
                    <i class="material-icons right">arrow_drop_down</i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- Dropdown Structure -->
    <ul id="dropdown1" class="dropdown-content">
        <li>
            <a href="../account/getUser.do"><i class="fa fa-user fa-fw"></i> 个人中心</a>
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
                                    <a href="/DocumentManaging/getFileOfApplying.do">查询</a>
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
                            <a href="/conference/getAllConference.do">会议查询</a>
                        </li>
                        <li>
                            <a href="/conference/getMeetingStatistical.do">会议统计</a>
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
                            <a href="/user/getuser.do">用户查询</a>
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
                收文登记表
            </h1>
            <ol class="breadcrumb">
                <li><a>文档管理系统</a></li>
                <li><a>收文登记表</a></li>
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
                            <form class="col s12" action="DocumentManaging/updateFileofReceiving.do" id="fileform1" method="POST">
                                <input name="sid" type="hidden" value="${file.sid}">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="title" name="title" type="text" class="validate" value="${file.title}">
                                        <label class="active" for="title">来文标题</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <input id="number" name="number1" type="text" class="validate" value="${file.number1}">
                                        <label class="active" for="number">来文号</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input id="department" name="department" type="text" class="validate" value="${file.department}">
                                        <label class="active" for="department">来文单位</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <input id="time" name="time1" type="text" class="Wdate validate" value="<fmt:formatDate value='${file.time1}' pattern='yyyy-MM-dd HH:mm:ss' />" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'dotime\')||\'new Date()\'}'})"/>
                                        <label class="active" for="time">来文时间</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input id="dotime" name="dotime" type="text" class="Wdate validate" value="<fmt:formatDate value='${file.dotime}' pattern='yyyy-MM-dd HH:mm:ss' />" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'time\')}'})"/>
                                        <label class="active" for="dotime">办理时间</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="Wpishi" name="wpishi" type="text" class="validate"value="${file.wpishi}">
                                        <label class="active" for="Wpishi">委领导批示</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="direction" name="direction" type="text" class="validate"value="${file.direction}">
                                        <label class="active" for="direction">流向</label>
                                    </div>
                                </div>
                            </form>
                            <a class="waves-effect waves-light btn-large" id="modify">修改</a>
                            <a disabled class="waves-effect waves-light btn-large" id="save" >保存</a>
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
<script src="js/raphael-2.1.0.min.js"></script>
<script src="js/morris.js"></script>


<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>

<script src="js/jquery.chart.js"></script>
<script src="js/jquery.dataTables.js"></script>
<script src="js/dataTables.bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
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
        if ($("#number").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("来文号不能为空！");
            return false;
        }
        if ($("#department").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("来文单位不能为空！");
            return false;
        }
        if ($("#time").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("来文时间不能为空！");
            return false;
        }
        if ($("#dotime").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("办理时间不能为空！");
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
        if ($("#direction").val() == "") {
            $("#textfield").addClass("alert alert-warning");
            $("#textfield").text("流向不能为空！");
            return false;
        }
        $("#textfield").removeClass("alert alert-warning");
        $("#textfield").text("");
        document.getElementById("fileform1").submit();
        return true;
    });
</script>
<script type="text/javascript">
    var power = '<%=request.getSession().getAttribute("power")%>' ;
    var admin = document.getElementById("admin");
    if (power == "0")
        admin.style.display="none";

    $("#modify").click(function () {
        $(".validate").attr("disabled", false);
        $("#save").attr("disabled", false);
        $("#modify").attr("disabled", true);
    });
</script>
</body>
</html>
