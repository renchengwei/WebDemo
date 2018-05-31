

$(document).ready(function() {
	var $datatable = $('#datatable-checkbox');
	$datatable.DataTable({
	  "serverSide": true,
	  "ajax":appServer + "/role/queryRoleByPage.json",
	  "paging":true,
	  "pageLength":20,
	  "searching":false,
	  "lengthChange": false,
	  "ordering":false,
	  "columns": [
		{ "data": ""},
		{ "data": "name"},
		{ "data": "available"},
		{ "data": "description"},
		{ "data": "id"}
	  ],
	  "dom": "<'row'<'menutool col-xs-6'><'searchtool col-xs-6 text-right'>>lrtip",
	  initComplete: function () {
			$(".searchtool").append("<input type='text' id='first-name' placeholder='名称' class='form-control'>");
			$(".searchtool").append("<button id='datainit' type='button' class='btn btn-default'> 查询</button>");
			$(".menutool").append("<button id='add' type='button' class='btn btn-primary'><span class='fa fa-plus'></span> 新增</button>");
		 	$("#add").click(addrole);
		  },
	   "columnDefs":[
		   { "targets": 0,
			    "render": function ( data, type, full, meta ) {
			    	return '<input type="checkbox"  class="flat">';
			    }
		   },
		   { "targets": 4,
			  "data":"id",
			  "className":"dataTables_empty",
			  "render": function ( data, type, full, meta ) {
				  return '<button type="button" onclick="toeditrole('+ data + ')"; class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>修改</button>'+
		      		'<button type="button" onclick="deleterole('+ data + ')"; class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>';
			   }
		   }
	    ]
	});
});

//新增角色
function addrole() {
	window.location= appServer + "/role/toAddRole";
}

//编辑角色
function toeditrole(id) {
	window.location= appServer + "/permission/toEditRole?id=" + id;
}

//删除角色
function deleterole(id) {
	bootbox.confirm({
	    message: "权限删除后会影响相关的人员角色！确定删除权限?",
	    buttons: {
	        confirm: {
	            label: '是',
	            className: 'btn-info'
	        },
	        cancel: {
	            label: '否',
	            className: 'btn-danger'
	        }
	    },
	    callback: function (result) {
	    	if(result) {
	    		$.post({
					url:appServer + "/permission/deletePermission.json",
					type:"post",
					data:{"id":id},
					success:function(){
						bootbox.alert({
			    			message:"权限已删除!", 
			    			buttons : {
			    				ok: {
			    		            label: '确定',
			    		            className: 'btn-success'
			    		        }
			    			},
			    			callback:function(){
			    				$('#datatable-checkbox').DataTable().ajax.reload();
			    			}
			    		});
					}
				});
	    	}
	    }
	});
}