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

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="${staticServer}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${staticServer}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${staticServer}/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${staticServer}/css/custom.css" rel="stylesheet">
  </head>

  <body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="/left" />
			<jsp:include page="/top" />

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
						<div class="x_content">
							<span class="section">操作失败</span>
							<div class="col-middle">
								<div class="text-center text-center">
									<h2 class="text-danger">
										<c:choose>
											<c:when test="${not empty result}">
												${result.message}
											</c:when>
											<c:otherwise>
												操作失败！
											</c:otherwise>
										</c:choose>
									</h2>
									<p>
										<c:choose>
											<c:when test="${not empty result && not empty result.pageItems}">
												<c:forEach items="${result.pageItems}" var="item">
													<a href="${appServer}${item.url}" class="btn btn-link">${item.message }</a>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<a href="javascript:history.go(-1);" class="btn btn-link">返回上一页</a>
											</c:otherwise>
										</c:choose>
									</p>
								</div>
							</div>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
			<jsp:include page="/footer" />
		</div>
	</div>

	<!-- jQuery -->
    <script src="${appServer}/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${appServer}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${appServer}/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${appServer}/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${appServer}/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${appServer}/vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="${appServer}/vendors/moment/min/moment.min.js"></script>
    <script src="${appServer}/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="${appServer}/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="${appServer}/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="${appServer}/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="${appServer}/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="${appServer}/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="${appServer}/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="${appServer}/vendors/parsleyjs/dist/parsley.min.js"></script>
    <script src="${appServer}/vendors/parsleyjs/dist/i18n/zh_cn.js"></script>
    <!-- Autosize -->
    <script src="${appServer}/vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="${appServer}/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="${appServer}/vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${appServer}/js/custom.js"></script>
	
	<script type="text/javascript">
		
		
	</script>
  </body>
</html>