<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<body>
	<!--header start-->
	<header class="header blue-bg">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right" data-original-title="导航切换"></div>
		</div>
		<!--logo start-->
		<a href="${appServer}/index.html" class="logo">分布式权限管理系统<span></span></a>
		<!--logo end-->

		<div class="top-nav ">
			<!--search & user info start-->
			<ul class="nav pull-right top-menu">
				<!-- user login dropdown start-->
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
						<img alt="" src="${appServer}/img/avatar1_small.jpg"> 
						<span class="username">Jhon Doue</span> 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li><a href="#"><i class=" fa fa-suitcase"></i>个人信息</a></li>
						<li><a href="#"><i class="fa fa-cog"></i> 修改密码</a></li>
						<li><a href="#"><i class="fa fa-bell-o"></i> Notification</a></li>
						<li><a href="/WebDemo/logout"><i class="fa fa-key"></i>退出系统</a></li>
					</ul>
				</li>
				<!-- user login dropdown end -->
			</ul>
			<!--search & user info end-->
		</div>
	</header>
	<!--header end-->
</body>
</html>