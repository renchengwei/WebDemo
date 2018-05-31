<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<body>
	<div class="col-md-3 left_col">
       <div class="left_col scroll-view">
         <div class="navbar nav_title" style="border: 0;">
           <a href="${appServer}index" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
         </div>

         <div class="clearfix"></div>

         <!-- sidebar menu -->
         <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
           <div class="menu_section">
             <ul class="nav side-menu">
               <li><a href="${appServer}index"><i class="fa fa-home"></i> 首页</a></li>
               <li><a><i class="fa fa-edit"></i> 系统用户 <span class="fa fa-chevron-down"></span></a>
                 <ul class="nav child_menu">
                   <li><a href="form">人员管理</a></li>
                   <li><a href="form_advanced">个人信息</a></li>
                   <li><a href="form_validation">修改密码</a></li>
                 </ul>
               </li>
               <li><a><i class="fa fa-desktop"></i> 权限角色 <span class="fa fa-chevron-down"></span></a>
                 <ul class="nav child_menu">
                   <li><a href="${appServer}permission/permissionList">权限管理</a></li>
                   <li><a href="${appServer}role/roleList">角色管理</a></li>
                 </ul>
               </li>
               <li><a><i class="fa fa-desktop"></i> 系统监控 <span class="fa fa-chevron-down"></span></a>
                 <ul class="nav child_menu">
                   <li><a href="general_elements">数据库监控</a></li>
                   <li><a href="general_elements">在线用户</a></li>
                 </ul>
               </li>
               <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>
             </ul>
           </div>
         </div>
         <!-- /sidebar menu -->
       </div>
     </div>
</body>
</html>