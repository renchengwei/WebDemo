<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!-- iCheck -->
    <link href="${staticServer}/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="${staticServer}/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
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
                    <form id="form" action="${appServer}/role/addRole" class="form-horizontal form-label-left" data-parsley-validate>
					  <span class="section">新增角色</span>
                      <div class="form-group">
                        <label for="name" class="control-label col-md-3 col-sm-3 col-xs-12" >角色名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="name" name="name" required class="form-control col-md-7 col-xs-12" placeholder="角色名称">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">是否启用<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <label class="checkbox-inline">
                              <input type="radio" class="flat" checked name="available" value="1"> 启用
                            </label>
                            <label class="checkbox-inline">
                              <input type="radio" class="flat"  name="available" value="0"> 禁用
                            </label>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="orderNo" class="control-label col-md-3 col-sm-3 col-xs-12">角色描述
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        	<textarea id="description" name="description" class="form-control col-md-7 col-xs-12"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button class="btn btn-primary" id="btnback" type="button">返回</button>
                          <button type="submit" id="btnsumit" class="btn btn-success">提交</button>
                        </div>
                      </div>
                    </form>
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
    <!-- iCheck -->
    <script src="${appServer}/vendors/iCheck/icheck.min.js"></script>
    <script src="${appServer}/vendors/bootbox/bootbox.min.js"></script>
    <!-- Parsley -->
    <script src="${appServer}/vendors/parsleyjs/dist/parsley.min.js"></script>
    <script src="${appServer}/vendors/parsleyjs/dist/i18n/zh_cn.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${appServer}/js/custom.js"></script>
	
	<script type="text/javascript">
		var appServer = "${appServer}";
		$("#btnback").click(function() {
			window.location.href= appServer + "/role/roleList";
		});
	</script>
	
  </body>
</html>
