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
    <link href="${appServer}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${appServer}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_content">
							<span class="section">操作成功</span>
							<div class="col-middle">
								<div class="text-center text-center">
									<h2 class="text-success">
										<c:choose>
											<c:when test="${not empty result}">
												${result.message}
											</c:when>
											<c:otherwise>
												操作成功！
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
												<a href="#" class="btn btn-link">返回上一页</a>
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
			<jsp:include page="/jsp/footer.jsp" />
		</div>
	</div>

	<!-- jQuery -->
    <script src="${appServer}/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${appServer}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${appServer}/js/custom.js"></script>
  </body>
</html>