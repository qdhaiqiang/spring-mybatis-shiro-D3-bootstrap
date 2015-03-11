<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
    <title>Londinium - premium responsive admin template by Eugene Kopyov</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/londinium-theme.css" rel="stylesheet" type="text/css">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/icons.css" rel="stylesheet" type="text/css">

    <link href="/js/plugins/charts/c3/c3.css" rel="stylesheet" type="text/css">

    <link href="/css/googlefont.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="/js/jquery.min.js"></script>

    <script type="text/javascript" src="/js/plugins/interface/daterangepicker.js"></script>
    <script type="text/javascript" src="/js/plugins/interface/moment.js"></script>
    <script type="text/javascript" src="/js/plugins/interface/jgrowl.min.js"></script>

    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/application_blank.js"></script>

    <script type="text/javascript" src="/js/d3.v3.min.js"></script>
    <script type="text/javascript" src="/js/plugins/charts/c3/c3.js"></script>
    <script type="text/javascript" src="/js/plugins/cloud-tag/d3.layout.cloud.js"></script>

    <style type="text/css">
        .panel-height {
            height: 520px; / change according to your requirement/
        }

        /*涟漪图*/
        .link {
            fill: none;
            stroke: #666;
            stroke-width: 1.5px;
        }

        #licensing {
            fill: green;
        }

        .link.licensing {
            stroke: green;
        }

        .link.resolved {
            stroke-dasharray: 0,2 1;
        }

        circle {
            fill: #ccc;
            stroke: #333;
            stroke-width: 1.5px;
        }

        text {
            font: 10px sans-serif;
            pointer-events: none;
            text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, 0 -1px 0 #fff, -1px 0 0 #fff;
        }

        /*云图*/
       .legend {
           border: 1px solid #555555;
           border-radius: 5px 5px 5px 5px;
           font-size: 0.8em;
           margin: 10px;
           padding: 8px;
       }
        .bld {
            font-weight: bold;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<div class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#"><img src="/images/logo.png" alt="Londinium"></a>
        <a class="sidebar-toggle"><i class="icon-paragraph-justify2"></i></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-icons">
            <span class="sr-only">Toggle navbar</span>
            <i class="icon-grid3"></i>
        </button>
        <button type="button" class="navbar-toggle offcanvas">
            <span class="sr-only">Toggle navigation</span>
            <i class="icon-paragraph-justify2"></i>
        </button>
    </div>

    <ul class="nav navbar-nav navbar-right collapse" id="navbar-icons">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown">
                <i class="icon-people"></i>
                <span class="label label-default">2</span>
            </a>
            <div class="popup dropdown-menu dropdown-menu-right">
                <div class="popup-header">
                    <a href="#" class="pull-left"><i class="icon-spinner7"></i></a>
                    <span>Activity</span>
                    <a href="#" class="pull-right"><i class="icon-paragraph-justify"></i></a>
                </div>
                <ul class="activity">
                    <li>
                        <i class="icon-cart-checkout text-success"></i>
                        <div>
                            <a href="#">Eugene</a> ordered 2 copies of <a href="#">OEM license</a>
                            <span>14 minutes ago</span>
                        </div>
                    </li>
                    <li>
                        <i class="icon-heart text-danger"></i>
                        <div>
                            Your <a href="#">latest post</a> was liked by <a href="#">Audrey Mall</a>
                            <span>35 minutes ago</span>
                        </div>
                    </li>
                    <li>
                        <i class="icon-checkmark3 text-success"></i>
                        <div>
                            Mail server was updated. See <a href="#">changelog</a>
                            <span>About 2 hours ago</span>
                        </div>
                    </li>
                    <li>
                        <i class="icon-paragraph-justify2 text-warning"></i>
                        <div>
                            There are <a href="#">6 new tasks</a> waiting for you. Don't forget!
                            <span>About 3 hours ago</span>
                        </div>
                    </li>
                </ul>
            </div>
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown">
                <i class="icon-paragraph-justify2"></i>
                <span class="label label-default">6</span>
            </a>
            <div class="popup dropdown-menu dropdown-menu-right">
                <div class="popup-header">
                    <a href="#" class="pull-left"><i class="icon-spinner7"></i></a>
                    <span>Messages</span>
                    <a href="#" class="pull-right"><i class="icon-new-tab"></i></a>
                </div>
                <ul class="popup-messages">
                    <li class="unread">
                        <a href="#">
                            <img src="http://placehold.it/300" alt="" class="user-face">
                            <strong>Eugene Kopyov <i class="icon-attachment2"></i></strong>
                            <span>Aliquam interdum convallis massa...</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="http://placehold.it/300" alt="" class="user-face">
                            <strong>Jason Goldsmith <i class="icon-attachment2"></i></strong>
                            <span>Aliquam interdum convallis massa...</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="http://placehold.it/300" alt="" class="user-face">
                            <strong>Angel Novator</strong>
                            <span>Aliquam interdum convallis massa...</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="http://placehold.it/300" alt="" class="user-face">
                            <strong>Monica Bloomberg</strong>
                            <span>Aliquam interdum convallis massa...</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="http://placehold.it/300" alt="" class="user-face">
                            <strong>Patrick Winsleur</strong>
                            <span>Aliquam interdum convallis massa...</span>
                        </a>
                    </li>
                </ul>
            </div>
        </li>

        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle">
                <i class="icon-grid"></i>
            </a>
            <div class="popup dropdown-menu dropdown-menu-right">
                <div class="popup-header">
                    <a href="#" class="pull-left"><i class="icon-spinner7"></i></a>
                    <span>Tasks list</span>
                    <a href="#" class="pull-right"><i class="icon-new-tab"></i></a>
                </div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Description</th>
                        <th>Category</th>
                        <th class="text-center">Priority</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><span class="status status-success item-before"></span> <a href="#">Frontpage fixes</a></td>
                        <td><span class="text-smaller text-semibold">Bugs</span></td>
                        <td class="text-center"><span class="label label-success">87%</span></td>
                    </tr>
                    <tr>
                        <td><span class="status status-danger item-before"></span> <a href="#">CSS compilation</a></td>
                        <td><span class="text-smaller text-semibold">Bugs</span></td>
                        <td class="text-center"><span class="label label-danger">18%</span></td>
                    </tr>
                    <tr>
                        <td><span class="status status-info item-before"></span> <a href="#">Responsive layout changes</a></td>
                        <td><span class="text-smaller text-semibold">Layout</span></td>
                        <td class="text-center"><span class="label label-info">52%</span></td>
                    </tr>
                    <tr>
                        <td><span class="status status-success item-before"></span> <a href="#">Add categories filter</a></td>
                        <td><span class="text-smaller text-semibold">Content</span></td>
                        <td class="text-center"><span class="label label-success">100%</span></td>
                    </tr>
                    <tr>
                        <td><span class="status status-success item-before"></span> <a href="#">Media grid padding issue</a></td>
                        <td><span class="text-smaller text-semibold">Bugs</span></td>
                        <td class="text-center"><span class="label label-success">100%</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </li>

        <li class="user dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown">
                <img src="http://placehold.it/300" alt="">
                <span>Eugene Kopyov</span>
                <i class="caret"></i>
            </a>
            <ul class="dropdown-menu dropdown-menu-right icons-right">
                <li><a href="#"><i class="icon-user"></i> Profile</a></li>
                <li><a href="#"><i class="icon-bubble4"></i> Messages</a></li>
                <li><a href="#"><i class="icon-cog"></i> Settings</a></li>
                <li><a href="#"><i class="icon-exit"></i> Logout</a></li>
            </ul>
        </li>
    </ul>
</div>
<!-- /navbar -->


<!-- Page container -->
<div class="page-container">


<!-- Sidebar -->
<div class="sidebar">
    <div class="sidebar-content">

        <!-- User dropdown -->
        <div class="user-menu dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="http://placehold.it/300" alt="">
                <div class="user-info">
                    Madison Gartner <span>Web Developer</span>
                </div>
            </a>
            <div class="popup dropdown-menu dropdown-menu-right">
                <div class="thumbnail">
                    <div class="thumb">
                        <img alt="" src="http://placehold.it/300">
                        <div class="thumb-options">
									<span>
										<a href="#" class="btn btn-icon btn-success"><i class="icon-pencil"></i></a>
										<a href="#" class="btn btn-icon btn-success"><i class="icon-remove"></i></a>
									</span>
                        </div>
                    </div>

                    <div class="caption text-center">
                        <h6>Madison Gartner <small>Front end developer</small></h6>
                    </div>
                </div>

                <ul class="list-group">
                    <li class="list-group-item"><i class="icon-pencil3 text-muted"></i> My posts <span class="label label-success">289</span></li>
                    <li class="list-group-item"><i class="icon-people text-muted"></i> Users online <span class="label label-danger">892</span></li>
                    <li class="list-group-item"><i class="icon-stats2 text-muted"></i> Reports <span class="label label-primary">92</span></li>
                    <li class="list-group-item"><i class="icon-stack text-muted"></i> Balance <h5 class="pull-right text-danger">$45.389</h5></li>
                </ul>
            </div>
        </div>
        <!-- /user dropdown -->


        <!-- Main navigation -->
        <ul class="navigation">
            <li><a href="index.html"><span>系统首页</span> <i class="icon-screen2"></i></a></li>
            <li>
                <a href="#"><span>数据报表</span> <i class="icon-insert-template"></i></a>
                <ul>
                <c:forEach items="${chartsMenuList}" var="item">
                    <c:choose>
                        <c:when test="${item.active}">
                            <li class="active"><a href="${item.url}">${item.title}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${item.url}">${item.title}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                </ul>
            </li>
            <li>
                <a href="#"><span>其他业务</span> <i class="icon-stack"></i></a>
                <ul>
                    <li><a href="#">Second level first item</a></li>
                    <li><a href="#">Second level second item</a>
                        <ul>
                            <li><a href="#">Third level first item</a></li>
                            <li><a href="#">Third level second item</a></li>
                            <li><a href="#">Third level third item</a>
                                <ul>
                                    <li><a href="#">Fourth level first item</a></li>
                                    <li><a href="#">Fourth level second item</a></li>
                                    <li><a href="#">Fourth level third item</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Third level second item</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Second level third item</a></li>
                </ul>
            </li>
        </ul>
        <!-- /main navigation -->

    </div>
</div>
<!-- /sidebar -->


<!-- Page content -->
<div class="page-content">


    <!-- Page header -->
    <div class="page-header">
        <div class="page-title">
            <h3>统计报表 <small>根据数据表格，显示数据结构</small></h3>
        </div>
        <div id="reportrange" class="range">
            <div class="visible-xs header-element-toggle">
                <a class="btn btn-primary btn-icon"><i class="icon-calendar"></i></a>
            </div>
            <div class="date-range"></div>
            <span class="label label-danger">9</span>
        </div>
    </div>
    <!-- /page header -->


    <!-- Breadcrumbs line -->
    <div class="breadcrumb-line">
        <ul class="breadcrumb">
            <li><a href="index.html">首页</a></li>
            <li><a href="blank_wide_left.html">数据查询</a></li>
            <li class="active">数据报表</li>
        </ul>

        <div class="visible-xs breadcrumb-toggle">
            <a class="btn btn-link btn-lg btn-icon" data-toggle="collapse" data-target=".breadcrumb-buttons"><i class="icon-menu2"></i></a>
        </div>

        <ul class="breadcrumb-buttons collapse">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-search3"></i> <span>Search</span> <b class="caret"></b></a>
                <div class="popup dropdown-menu dropdown-menu-right">
                    <div class="popup-header">
                        <a href="#" class="pull-left"><i class="icon-paragraph-justify"></i></a>
                        <span>Quick search</span>
                        <a href="#" class="pull-right"><i class="icon-new-tab"></i></a>
                    </div>
                    <form action="#" class="breadcrumb-search">
                        <input type="text" placeholder="Type and hit enter..." name="search" class="form-control autocomplete">
                        <div class="row">
                            <div class="col-xs-6">
                                <label class="radio">
                                    <input type="radio" name="search-option" class="styled" checked="checked">
                                    Everywhere
                                </label>
                                <label class="radio">
                                    <input type="radio" name="search-option" class="styled">
                                    Invoices
                                </label>
                            </div>

                            <div class="col-xs-6">
                                <label class="radio">
                                    <input type="radio" name="search-option" class="styled">
                                    Users
                                </label>
                                <label class="radio">
                                    <input type="radio" name="search-option" class="styled">
                                    Orders
                                </label>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-block btn-success" value="Search">
                    </form>
                </div>
            </li>

            <li class="language dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="/images/flags/german.png" alt=""> <span>German</span> <b class="caret"></b></a>
                <ul class="dropdown-menu dropdown-menu-right icons-right">
                    <li><a href="#"><img src="/images/flags/ukrainian.png" alt=""> Ukrainian</a></li>
                    <li class="active"><a href="#"><img src="/images/flags/english.png" alt=""> English</a></li>
                    <li><a href="#"><img src="/images/flags/spanish.png" alt=""> Spanish</a></li>
                    <li><a href="#"><img src="/images/flags/german.png" alt=""> German</a></li>
                    <li><a href="#"><img src="/images/flags/hungarian.png" alt=""> Hungarian</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- /breadcrumbs line -->


    <!-- Callout -->
    <div class="callout callout-danger fade in">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <h5>查询成功</h5>
        <p>
            您好，这里是一个查询的报表
        </p>
    </div>
    <!-- /callout -->

    <!-- Default panel -->
    <form class="form-horizontal" role="form" action="/rest/xunjia/xunjiaByDate">

    <!-- Basic inputs -->
    <div class="panel panel-default">
    <div class="panel-heading"><h6 class="panel-title"><i class="icon-bubble4"></i> 评论数据查询</h6></div>
    <div class="panel-body">

    <div class="form-group">
        <label class="col-sm-2 control-label">根据日期查询: </label>
        <div class="col-sm-10">
            <div class="row">
                <div class="col-md-6">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="icon-grid"> 开始日期</i></span>
                        <input type="text" class="form-control" name="from" value="2015-02-10">
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="icon-grid"> 结束日期</i></span>
                        <input type="text" class="form-control" name="to" value="2015-03-10">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-actions text-right">
        <button type="submit" class="btn btn-primary">开始查询</button>
    </div>
    </div>
    </div>
    <!-- /basic inputs -->

    </form>
    <!-- /form panel -->

    <!-- Default table -->
    <div class="panel panel-default">
        <div class="panel-heading"><h6 class="panel-title"><i class="icon-table2"></i> 查询表格</h6></div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>用户手机号</th>
                    <th>操作时间</th>
                    <th>评论内容</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.phone}</td>
                        <td>${item.date}</td>
                        <td>${item.comment}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- /default table -->

    <!-- Default panel -->
    <div class="panel panel-default">
        <div class="panel-heading"><h6 class="panel-title">舆情监控</h6></div>
        <div class="panel-body panel-height" id="xunjiaLink">
        </div>
    </div>
    <!-- /default panel -->

    <!-- Default panel -->
    <div class="panel panel-default">
        <div class="panel-heading"><h6 class="panel-title">评论量、人数对比图</h6></div>
        <div class="panel-body panel-height" id="xunjiaChart">
        </div>
    </div>
    <!-- /default panel -->

    <!-- Footer -->
    <div class="footer clearfix">
        <div class="pull-left">&copy; 2013. Londinium Admin Template by <a href="http://themeforest.net/user/Kopyov">Eugene Kopyov</a></div>
        <div class="pull-right icons-group">
            <a href="#"><i class="icon-screen2"></i></a>
            <a href="#"><i class="icon-balance"></i></a>
            <a href="#"><i class="icon-cog3"></i></a>
        </div>
    </div>
    <!-- /footer -->


</div>
<!-- /page content -->

</div>
<!-- /content -->

<script type="text/javascript">
    //xunjiaLink
    var frequency_list = [{"text":"study","size":40}
        <c:forEach var="item" items="${wordMap}">,{"text":"${item.key}","size":${item.value+20}}</c:forEach>
    ];

    var color = d3.scale.linear()
            .domain([0,1,2,3,4,5,6,10,15,20,100])
            .range(["#ddd", "#ccc", "#bbb", "#aaa", "#999", "#888", "#777", "#666", "#555", "#444", "#333", "#222"]);

    d3.layout.cloud().size([900, 400])
            .words(frequency_list)
            .rotate(0)
            .fontSize(function(d) { return d.size; })
            .on("end", draw)
            .start();

    function draw(words) {
        d3.select("#xunjiaLink").append("svg")
                .attr("width", 1000)
                .attr("height", 500)
                .attr("class", "wordcloud")
                .append("g")
            // without the transform, words words would get cutoff to the left and top, they would
            // appear outside of the SVG area
                .attr("transform", "translate(320,200)")
                .selectAll("text")
                .data(words)
                .enter().append("text")
                .style("font-size", function(d) { return d.size + "px"; })
                .style("fill", function(d, i) { return color(i); })
                .attr("transform", function(d) {
                    return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                })
                .text(function(d) { return d.text; });
    }

    //折线图
    var chart = c3.generate({
        bindto: '#xunjiaChart',
        padding: {
            right: 50,
            bottom: 40
        },
        data: {
            x: 'x',
            columns: [
                ['x'<c:forEach var="item" items="${chartData}">,"${item.key}"</c:forEach>],
                ['评论量'<c:forEach var="item" items="${chartData}">,${item.value}</c:forEach>],
                ['评论人数'<c:forEach var="item" items="${chartUserData}">,${item.value}</c:forEach>]
            ]
        },
        axis: {
            x: {
                type: 'timeseries',
                tick: {
                    format: '%Y-%m-%d'
                }
            }
        }
    });
</script>
</body>
</html>