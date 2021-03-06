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
    if (flag == 'registerSuccess'){
        new TipBox({type:'success',str:'登记成功',setTime:1500});
    } else if (flag == 'modifySuccess') {
        new TipBox({type:'success',str:'修改成功！',setTime:1500});
    } else if (flag == 'deleteSuccess') {
        new TipBox({type:'success',str:'删除成功！',setTime:1500});
    } else if (flag == 'deleteFail') {
        new TipBox({type:'error',str:'删除失败！',hasBtn:true});
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
                    <a href="#" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> 文档管理<span class="fa arrow"></span></a>
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
                    <a href="form.html" class="active-menu waves-effect waves-dark"><i class="fa fa-edit"></i> 会议管理<span class="fa arrow"></span></a>
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
                会议查询
            </h1>
            <ol class="breadcrumb">
                <li><a>文档管理系统</a></li>
                <li class="active">会议查询</li>
            </ol>

        </div>

        <div id="page-inner">

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="card">
                        <div class="card-action">
                            会议查询
                        </div>
                        <div class="card-content">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th class="center single-line">会议编号</th>
                                        <th class="center single-line">会议召开人</th>
                                        <th class="center single-line">会议时间</th>
                                        <th class="center single-line">是否召开</th>
                                        <th class="center single-line">会议性质</th>
                                        <th class="center single-line">会议地点</th>
                                        <th class="center single-line">会议内容</th>
                                        <th class="center single-line">参与者</th>
                                        <th class="center single-line">会议文档</th>
                                        <th class="center single-line">删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach items="${meetings}"  var="meeting">
                                    <tr>
                                        <td class="center modify">${meeting.mid}</td>
                                        <td class="center modify">${meeting.holder}</td>
                                        <td class="center modify"><fmt:formatDate value="${meeting.mtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                        <c:if test="${meeting.ishold eq true}">
                                            <td class="center modify">是</td>
                                        </c:if>
                                        <c:if test="${meeting.ishold eq false}">
                                            <td class="center modify">否</td>
                                        </c:if>
                                        <td class="center modify">${meeting.host }</td>
                                        <td class="center modify">${meeting.place}</td>
                                        <td class="center modify">${meeting.content}</td>
                                        <td class="center modify">${meeting.names}</td>
                                        <td class="center modify">${meeting.document}</td>
                                        <td class="center">
                                            <button class="btn btn-danger">删除</button>
                                        </td>
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
    <script src="js/raphael-2.1.0.min.js"></script>
    <script src="js/morris.js"></script>


    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>

    <script src="js/jquery.chart.js"></script>
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
        	var id= $(this).parent("tr").children("td").html();     	
        	document.write("<form action=../conference/getMeetingById.do method=post name=formx1 style='display:none'>");
            document.write("<input type=hidden name=mid value='"+id+"'>");
        	document.write("<input type=hidden name=jsp value=Meeting-Modify.jsp>");
        	document.write("</form>");
        	document.formx1.submit();
        });
        
        $(".btn-danger").click(function() {
            if (confirm("确定要删除吗？")){
                var id= $(this).parent("td").parent("tr").children("td").html();
                document.write("<form action=../conference/deleteMeetingById.do method=post name=formx1 style='display:none'>");
                document.write("<input type=text name=mid value='"+id+"'>");
                document.formx1.submit();
            }
        });

    </script>
</div>
</body>
</html>
