

$(document).ready(function() {
	var $datatable = $('#datatable-checkbox');
	$datatable.DataTable({
		"ajax": {
		    "url": appServer + "/permission/queryPermissions.json",
		    "contentType": "application/json",
		    "type": "post",
		    "dataSrc":""
		},
	  "paging":false,
	  "searching":false,
	  "ordering":false,
	  "info": false,
	  "columns": [
		{ "data": ""},
		{ "data": "name"},
		{ "data": "code"},
		{ "data": "type"},
		{ "data": "icon"},
		{ "data": "available"},
		{ "data": "orderNo"},
		{ "data": "id"},
		{ "data": "childrenCount"}
	  ],
	  "columnDefs":[
		  { "targets": 0,
		    "render": function ( data, type, full, meta ) {
		      return '<input type="checkbox"  class="flat">';
		    }
		  },
		  { "targets": 1,
			    "render": function ( data, type, full, meta ) {
			    	var result = data;
			    	if(full.childrenCount > 0) {
			    		result = "<a href='#' id='" + full.id + "' class='fa fa-chevron-right'></a> " + result;
			    	}
			    	
			    	if(full.type == "1" && full.parentId != -1) {
			    		result = "<span class='treegrid-indent'></span>" + result;
			    	}
			    	
			    	if(full.type == "2") {
			    		result = "<span class='treegrid-indent'></span><span class='treegrid-indent'></span>" + result;
			    	}
			    	
			    	return result;
			   }
		  },
		  { "targets": 3,
		    "data": "type",
		    "render": function ( data, type, full, meta ) {
		     	if(data == "0") {
		     		return "<span class='label label-primary'>目录</span>";
		     	} else if(data == "1") {
		     		return "<span class='label label-success'>菜单</span>";
		     	} else if(data == "2") {
		     		return "<span class='label label-info'>操作</span>";
		     	}
		    }
		  },
		  { "targets": 5,
		    "data": "available",
		    "render": function ( data, type, full, meta ) {
		      	if(data == "1") {
		      		return "<span class='label label-success'>启用</span>";
		      	}else{
		      		return "<span class='label label-danger'>禁用</span>";
		      	}
		    }
		  },
		  { "targets": 4,
		    "data": "icon",
		    "render": function ( data, type, full, meta ) {
		    	if(data != null) {
		    		return "<span class='" + data + "'></span>";
		    	}
		    	return "";
		    }
		  },
		  { "targets": 7,
		    "data":"id",
		    "className":"dataTables_empty",
			  "render": function ( data, type, full, meta ) {
		      return '<button type="button" onclick="toedittepermission('+ data + ')"; class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>修改</button>'+
		      		'<button type="button" onclick="deletepermission('+ data + ')"; class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>';
		    }
		  },
		  {"targets": 8,
			  "visible":false
		  }
	  ],
	  "dom": "<'row'<'menutool col-xs-6'><'searchtool col-xs-6 text-right'>>rt",
		  initComplete: function () {
			$(".searchtool").append("<input type='text' id='first-name' placeholder='名称' class='form-control'>");
			$(".searchtool").append("<button id='datainit' type='button' class='btn btn-default'> 查询</button>");
			$(".menutool").append("<button id='add' type='button' class='btn btn-primary'><span class='fa fa-plus'></span> 新增</button>");
		 	$("#add").click(addpermission);
		 	var table = $('#datatable-checkbox').DataTable();
		 	table.rows().iterator( 'row', function ( context, index ) {
		 		var parentId = this.row(index).data().parentId;
		 		var childrenCount = this.row(index).data().childrenCount;
		 		this.row(index).data().isopen=false;
		 		
		 		if(parentId != -1) {
		 			this.row( index ).node().hidden=true;
		 		}
		 	} );
		 	
		 	$("table tbody tr td a").click(function(){
		 		var id = $(this).attr("id");
		 		var flag;
		 		if($(this).hasClass("fa fa-chevron-right")) {
		 			$(this).removeClass("fa fa-chevron-right");
		 			$(this).addClass("fa fa-chevron-down");
		 			showChildren(id);
		 			flag = true;
		 		}else if($(this).hasClass("fa fa-chevron-down")) {
		 			$(this).removeClass("fa fa-chevron-down");
		 			$(this).addClass("fa fa-chevron-right");
		 			hideChildren(id);
		 			flag = false;
		 		}
		 		
		 		var table = $('#datatable-checkbox').DataTable();
		 	 	table.rows().iterator( 'row', function ( context, index ) {
		 	 		var currentId = this.row(index).data().id;
		 	 		if(currentId == id) {
		 	 			this.row(index).data().isopen=flag;
		 	 		}
		 	 	} );
		 	});
		  }
	}
	  );
});

function showChildren(id) {
	var table = $('#datatable-checkbox').DataTable();
 	table.rows().iterator( 'row', function ( context, index ) {
 		var parentId = this.row(index).data().parentId;
 		var isopen = this.row(index).data().isopen;
 		if(parentId == id) {
 			this.row( index ).node().hidden=false;
 			if(isopen) {
 				showChildren(this.row( index ).data().id);
 			}
 		}
 	} );
}

function hideChildren(id) {
	var table = $('#datatable-checkbox').DataTable();
 	table.rows().iterator( 'row', function ( context, index ) {
 		var parentId = this.row(index).data().parentId;
 		if(parentId == id) {
 			this.row( index ).node().hidden=true;
 			hideChildren(this.row( index ).data().id);
 		}
 	} );
}

//新增权限
function addpermission() {
	window.location= appServer + "/permission/toAddPermission.html";
}

function toedittepermission(id) {
	window.location= appServer + "/permission/toEditPermission.html?id=" + id;
}

//删除权限
function deletepermission(id) {
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