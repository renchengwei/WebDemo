<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="${appServer}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${appServer}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${appServer}/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="${appServer}/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${appServer}/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="${appServer}/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="${appServer}/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="${appServer}/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${appServer}/css/custom.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
      	<jsp:include page="/jsp/left.jsp" />
        <jsp:include page="/jsp/top.jsp" />

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
            <div class="clearfix"></div>
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_content">
                    <table id="datatable-checkbox" class="table table-striped table-bordered jambo_table bulk_action ">
                      <thead>
                        <tr>
                          <th>
							 <input type="checkbox" class="flat check-all">
						  </th>
                          <th>权限名称</th>
                          <th>授权标识</th>
                          <th>权限类型</th>
                          <th>图标</th>
                          <th>是否可用</th>
                          <th>排序号</th>
                          <th>操作</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
       </div>
       <jsp:include page="/jsp/footer.jsp" />
      </div>
    </div>
	
    <!-- jQuery -->
    <script src="${appServer}/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${appServer}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${appServer}/vendors/iCheck/icheck.min.js"></script>
    <script src="${appServer}/vendors/bootbox/bootbox.min.js"></script>
    <!-- Datatables -->
    <script src="${appServer}/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="${appServer}/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="${appServer}/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="${appServer}/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="${appServer}/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="${appServer}/js/custom.js"></script>
    <script src="${appServer}/js/permissionList.js"></script>
	<script type="text/javascript">
		var appServer = "${appServer}";
	</script>
  </body>
</html>