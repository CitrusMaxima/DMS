<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
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
                            <a href="#">主要领导签批文件登记表<span class="fa arrow"></span></a>
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
    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                会议统计
            </h1>
            <ol class="breadcrumb">
                <li><a>文档管理系统</a></li>
                <li><a>会议管理</a></li>
                <li class="active">会议统计</li>
            </ol>

        </div>
        <div id="page-inner">

            <div class="row">


                <div class="col-md-6 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="card-action">
                            会议时间统计图
                        </div>
                        <div class="card-content">
                            <div id="morris-bar-chart"></div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="card-action">
                            会议召开统计图
                        </div>
                        <div class="card-content">
                            <div id="morris-donut-chart"></div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="card-action">
                            会议总统计图
                        </div>
                        <div class="card-content">
                            <div id="morris-line-chart"></div>
                        </div>
                    </div>
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
    <script type="text/javascript" src="js/mdialog.js"></script>
    <script src="js/raphael-2.1.0.min.js"></script>
    <script src="js/morris.js"></script>


    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>

    <script src="js/jquery.chart.js"></script>
    <script type="text/javascript" src="js/zepto.min.js"></script>
    <script src="js/jquery.dataTables.js"></script>
    <script src="js/dataTables.bootstrap.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').dataTable();
        });
    </script>
    <script type="text/javascript">
        var power = '<%=request.getSession().getAttribute("power")%>' ;
        var admin = document.getElementById("admin");
        if (power == "0")
            admin.style.display="none";
    </script>

    <!-- Custom Js -->
    <%--<script src="js/custom-scripts.js"></script>--%>
    <script>
        (function ($) {
            "use strict";
            var mainApp = {

                initFunction: function () {
                    /*MENU
                     ------------------------------------*/
                    $('#main-menu').metisMenu();

                    $(window).bind("load resize", function () {
                        if ($(this).width() < 768) {
                            $('div.sidebar-collapse').addClass('collapse')
                        } else {
                            $('div.sidebar-collapse').removeClass('collapse')
                        }
                    });

                    /* MORRIS BAR CHART
                     -----------------------------------------*/
                    Morris.Bar({
                        element: 'morris-bar-chart',
                        data:arr1,
                        xkey: 'y',
                        ykeys: ['a', 'b'],
                        labels: ['已召开', '未召开'],
                        barColors: [
                            '#e96562','#414e63',
                            '#A8E9DC'
                        ],
                        hideHover: 'auto',
                        resize: true
                    });



                    /* MORRIS DONUT CHART
                     ----------------------------------------*/
                    Morris.Donut({
                        element: 'morris-donut-chart',
                        data:arr2,
                        colors: [
                            '#e96562',
                            '#414e63'
                        ],
                        resize: true
                    });

                    /* MORRIS LINE CHART
                     ----------------------------------------*/
                    Morris.Line({
                        element: 'morris-line-chart',
                        data: arr3,

                        xkey: 'y',
                        ykeys: ['a', 'b','c'],
                        labels: ['共计','已召开', '未召开'],
                        fillOpacity: 0.6,
                        hideHover: 'auto',
                        behaveLikeLine: true,
                        resize: true,
                        pointFillColors:['#ffffff'],
                        pointStrokeColors: ['black'],
                        lineColors:['#e96562','#414e63','gray']

                    });


                    $('.bar-chart').cssCharts({type:"bar"});
                    $('.donut-chart').cssCharts({type:"donut"}).trigger('show-donut-chart');
                    $('.line-chart').cssCharts({type:"line"});

                },

                initialization: function () {
                    mainApp.initFunction();

                }

            }
            // Initializing ///

            $(document).ready(function () {
                $(".dropdown-button").dropdown();
                $("#sideNav").click(function(){
                    if($(this).hasClass('closed')){
                        $('.navbar-side').animate({left: '0px'});
                        $(this).removeClass('closed');
                        $('#page-wrapper').animate({'margin-left' : '260px'});

                    }
                    else{
                        $(this).addClass('closed');
                        $('.navbar-side').animate({left: '-260px'});
                        $('#page-wrapper').animate({'margin-left' : '0px'});
                    }
                });

                mainApp.initFunction();
            });

            var a = [];
            <%
            List<String> valueList = (List<String>) request.getAttribute("s1");
            for (String currentValue : valueList) {%>
            a.push("<%=currentValue%>");
            <% } %>

            var b = [];
            <%
            List<String> valueList2 = (List<String>) request.getAttribute("s2");
            for (String currentValue2 : valueList2) {%>
            b.push("<%=currentValue2%>");
            <% } %>

            var c = new Array("y: '2014', a: 140, b: 90, c: 50",
                "y: '2015', a: 350, b: 185, c: 165",
                "y: '2016', a: 255, b: 90, c: 165",
                "y: '2017', a: 124, b: 84, c: 38",
                "y: '2018', a: 285, b: 112, c: 173");

            var arr1 = [];
            var arr2 = [];
            var arr3 = [];
            var obj1 = new Object();
            var obj2 = new Object();
            var obj3 = new Object();
            for(var i=0; i<a.length; i++){
                obj1[i] = eval('(' + "{"+a[i].toString()+"}" + ')');
                arr1.push(obj1[i]);
            }
            for(var j=0; j<b.length; j++){
                obj2[j] = eval('(' + "{"+b[j].toString()+"}" + ')');
                arr2.push(obj2[j]);
            }
            for(var k=0; k<c.length; k++){
                obj3[k] = eval('(' + "{"+c[k].toString()+"}" + ')');
                arr3.push(obj3[k]);
            }
            $(".dropdown-button").dropdown();

        }(jQuery));

    </script>

</div>
</body>
</html>
