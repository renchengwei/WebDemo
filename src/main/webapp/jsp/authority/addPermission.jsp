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
    <link href="${appServer}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${appServer}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${appServer}/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="${appServer}/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- ztree -->
    <link rel="stylesheet" href="${appServer}/vendors/zTree/css/metroStyle/metroStyle.css" type="text/css">

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
                    <form id="form" action="${appServer}/permission/addPermission.html" class="form-horizontal form-label-left" data-parsley-validate>
					  <span class="section">新增权限</span>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">权限类型 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          	<label class="checkbox-inline">
                              <input id = "abc" type="radio" class="flat"  name="type" value="0"> 一级菜单
                            </label>
                            <label class="checkbox-inline">
                              <input type="radio" class="flat" checked name="type" value="1"> 二级菜单
                            </label>
                            <label class="checkbox-inline">
                              <input type="radio" class="flat"  name="type" value="2"> 操作
                            </label>
                        </div>
                      </div> 
                      <div class="form-group">
                        <label for="name" class="control-label col-md-3 col-sm-3 col-xs-12" >权限名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="name" name="name" required class="form-control col-md-7 col-xs-12" placeholder="菜单名称或按钮名称">
                        </div>
                      </div>
                      <div class="form-group" id="parent_div">
                        <label for="parent" class="control-label col-md-3 col-sm-3 col-xs-12">上级目录 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="parent" name="parent" required class="form-control col-md-7 col-xs-12" readonly="readonly" style="cursor: pointer;" placeholder="菜单上级目录，一级菜单"
                          	data-toggle="modal" data-target=".bs-example-modal-sm">
                        </div>
                      </div>
                      <div class="form-group" id="menuURL_div">
                        <label for="menuURL" class="control-label col-md-3 col-sm-3 col-xs-12">菜单URL <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="menuURL" name="menuURL" required class="form-control col-md-7 col-xs-12" placeholder="菜单URL">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="code" class="control-label col-md-3 col-sm-3 col-xs-12">授权标识<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="code" name="code" data-parsley-group="group1" required class="form-control col-md-7 col-xs-12" placeholder="授权标识，如：user:list">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">是否启用<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <label class="checkbox-inline">
                              <input type="radio" class="flat" checked name="available" value="0"> 是
                            </label>
                            <label class="checkbox-inline">
                              <input type="radio" class="flat"  name="available" value="1"> 否
                            </label>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="orderNo" class="control-label col-md-3 col-sm-3 col-xs-12">排序号<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="orderNo" name="orderNo" data-parsley-group="group1" required class="form-control col-md-7 col-xs-12" value="0">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="icon" class="control-label col-md-3 col-sm-3 col-xs-12">图标 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="icon" name="icon"  class="form-control col-md-7 col-xs-12" placeholder="菜单图标">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="icon" class="control-label col-md-3 col-sm-3 col-xs-12">
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <code>获取图标：http://fontawesome.io/icons/</code>
                        </div>
                      </div>
                      <input type="hidden" id="parentId" name="parentId">
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
		<div class="modal fade bs-example-modal-sm" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel2">选择菜单</h4>
					</div>
					<div class="modal-body">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">选择</button>
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
    <!-- iCheck -->
    <script src="${appServer}/vendors/iCheck/icheck.min.js"></script>
    <!-- Parsley -->
    <script src="${appServer}/vendors/parsleyjs/dist/parsley.min.js"></script>
    <script src="${appServer}/vendors/parsleyjs/dist/i18n/zh_cn.js"></script>
    <!-- ztree -->
    <script type="text/javascript" src="${appServer}/vendors/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${appServer}/vendors/zTree/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${appServer}/vendors/zTree/js/jquery.ztree.exedit.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${appServer}/js/custom.js"></script>
    <script src="${appServer}/js/addPermission.js"></script>
	
	<script type="text/javascript">
	var setting = {
            view: {
                selectedMulti: true
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"父节点1", open:true},
            { id:11, pId:1, name:"父节点11"},
            { id:111, pId:11, name:"叶子节点111"},
            { id:112, pId:11, name:"叶子节点112"},
            { id:113, pId:11, name:"叶子节点113"},
            { id:114, pId:11, name:"叶子节点114"},
            { id:12, pId:1, name:"父节点12"},
            { id:121, pId:12, name:"叶子节点121"},
            { id:122, pId:12, name:"叶子节点122"},
            { id:123, pId:12, name:"叶子节点123"},
            { id:124, pId:12, name:"叶子节点124"},
            { id:13, pId:1, name:"父节点13", isParent:true},
            { id:2, pId:0, name:"父节点2"},
            { id:21, pId:2, name:"父节点21", open:true},
            { id:211, pId:21, name:"叶子节点211"},
            { id:212, pId:21, name:"叶子节点212"},
            { id:213, pId:21, name:"叶子节点213"},
            { id:214, pId:21, name:"叶子节点214"},
            { id:22, pId:2, name:"父节点22"},
            { id:221, pId:22, name:"叶子节点221"},
            { id:222, pId:22, name:"叶子节点222"},
            { id:223, pId:22, name:"叶子节点223"},
            { id:224, pId:22, name:"叶子节点224"},
            { id:23, pId:2, name:"父节点23"},
            { id:231, pId:23, name:"叶子节点231"},
            { id:232, pId:23, name:"叶子节点232"},
            { id:233, pId:23, name:"叶子节点233"},
            { id:234, pId:23, name:"叶子节点234"},
            { id:3, pId:0, name:"父节点3", isParent:true}
        ];

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });

//         var newCount = 1;
//         function addHoverDom(treeId, treeNode) {
//             var sObj = $("#" + treeNode.tId + "_span");
//             if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
//             var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
//                 + "' title='add node' onfocus='this.blur();'></span>";
//             sObj.after(addStr);
//             var btn = $("#addBtn_"+treeNode.tId);
//             if (btn) btn.bind("click", function(){
//                 var zTree = $.fn.zTree.getZTreeObj("treeDemo");
//                 zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
//                 return false;
//             });
//         };
//         function removeHoverDom(treeId, treeNode) {
//             $("#addBtn_"+treeNode.tId).unbind().remove();
//         };
		$("#btnback").click(function() {
			window.location.href="${appServer}/jsp/authority/permissionList.jsp";
		});
	
	</script>
  </body>
</html>
