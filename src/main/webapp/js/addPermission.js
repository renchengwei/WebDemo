$(document).ready(function() {
	var setting = {
        view: {
            selectedMulti: false
        },
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
    			pIdKey: "parentId",
    			rootPId: -1
            }
        },
        async: {
			enable: true,
			url: appServer + "/permission/queryPermissions.json",
			autoParam:["id=parentId"],
			dataFilter: ajaxDataFilter
		},
		callback:{
			onAsyncError:function(){
				alert("服务器异常");
			}
		}
		
    };

    var zNodes =[
        { id:-1,name:"一级菜单", isParent:true,type:"0"}
    ];
    
    function ajaxDataFilter(treeId, parentNode, responseData) {
    	if (responseData) {
    		for(var i =0; i < responseData.length; i++) {
	    		if(responseData[i].childrenCount > 0) {
	    			responseData[i].isParent = true;
	    		}
	    	}
	    }
    	return responseData;
    }
    
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	$("input:radio[name='type']").on('ifChecked', function(event) {
		$('#parent').val("");
		$('#parentId').val("");
		if($(this).val() == "0"){
			$("#parent_div").hide();
			$("#menuURL_div").hide();
			$('#parent').attr('required', false);
			$('#menuURL').attr('required', false);
		} else if($(this).val() == "1"){
			$("#parent_div").show();
			$("#menuURL_div").show();
			$('#parent').attr('equired', true);
			$('#menuURL').attr('required', true);
		}else {
			$("#parent_div").show();
			$("#menuURL_div").hide();
			$('#parent').attr('required', true);
			$('#menuURL').attr('required', false);
		}
	});
	
	$("#btnback").click(function() {
		window.location.href= appServer + "/jsp/authority/permissionList.jsp";
	});
	
	$("#form").parsley();
	
	$('#myModal').on('show.bs.modal', function (e) {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var node = treeObj.getNodeByParam("id", -1, null);
		if (node != null) {
			treeObj.reAsyncChildNodes(node, "refresh");
		}
	});
	
	$('#selectParentBtn').click(function(){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		if(nodes.length > 0) {
			var type = $("input:radio[name='type']:checked").val();
			var parentType = nodes[0].type;
			var id = nodes[0].id;
			var name = nodes[0].name;
			if(type == "1" && parentType != "0") {//菜单上级权限必须是目录
				bootbox.alert({
	    			message:"菜单上级权限类型只能为目录类型或一级菜单!", 
	    			buttons : {ok: {label: '确定',className: 'btn-warning'}
	    			}
	    		});
			}else if (type == "2" && parentType != "1") {
				bootbox.alert({
	    			message:"操作上级权限类型只能为菜单类型!", 
	    			buttons : {ok: {label: '确定',className: 'btn-warning'}
	    			}
	    		});
			}else {
				$("#parent").val(nodes[0].name);
				$("#parentId").val(nodes[0].id);
				$('#myModal').modal('hide');
			}
		}else {
			bootbox.alert({
    			message:"请选择上级权限!", 
    			buttons : {ok: {label: '确定',className: 'btn-warning'}
    			}
    		});
		}
		
	});
	
	if($('#parentId').val() != '') {
		var parentId = $('#parentId').val();
		if(parentId == -1) {
			$("#parent").val("一级菜单");
		}else {
			$.post({
				url:appServer + "/permission/getPermissionById.json",
				type:"post",
				data:{"id":parentId},
				dataType: "json",
				success:function(result){
					$("#parent").val(result.name);
				}
			});
		}
	}
});