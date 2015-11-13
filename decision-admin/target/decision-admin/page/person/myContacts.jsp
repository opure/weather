<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="/tag/pager.tld" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>通讯录 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<%-- <link rel="stylesheet" href="<%=basePath%>assets/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"> --%>
<style type="text/css">

	div.zTreeDemoBackground {
		width:250px;
		height:562px;
		text-align:left;
	}
	ul.ztree {
		margin-top: 10px;
		border: 5px solid #617775;
		background: #f0f6e4;
		width:240px;
		height:360px;
		overflow-y:scroll;
		overflow-x:auto;
	}
	
</style>
<link rel="stylesheet" href="<%=basePath%>assets/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/jquery-ui/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/contact.js"></script>

<script type="text/javascript">
		
		var uid = '${uid}';
		
		var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: { //利用 setting.data.keep.parent / leaf 属性 实现了父节点、叶子节点的状态锁定
				keep: {
					parent:false,
					leaf:false
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove
			}
		};

		var treeData = '${treeData}';
		var zNodesObj = $.parseJSON(treeData);
		var zNodes = zNodesObj;
		//var zNodes = [{"id":"94d6ebfa6422429b884850880a3f293e","pId":"43fba369247643429d79ebc8fe3d8723","name":"小白"},{"id":"43fba369247643429d79ebc8fe3d8723","pId":"1","name":"学生"},{"id":"db2f419065324efba45096337ff68849","pId":"43fba369247643429d79ebc8fe3d8721","name":"李老师"},{"id":"247e51a86e0e4beb8de66aa473f2d80f","pId":"43fba369247643429d79ebc8fe3d8721","name":"王老师"},{"id":"43fba369247643429d79ebc8fe3d8721","pId":"43fba369247643429d79ebc8fe3d8722","name":"一组"},{"id":"43fba369247643429d79ebc8fe3d8722","pId":"0","name":"同事"}];
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		
		$(document).ready(function(){
			// 初始化通讯录树
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			
			$("#addParent").bind("click", {isParent:true}, add);
			$("#addLeaf").bind("click", {isParent:false}, add);
			$("#edit").bind("click", edit);
			$("#remove").bind("click", remove);
			$("#clearChildren").bind("click", clearChildren);
			$("#addItem").bind("click", addItem);
			$("#editItem").bind("click", editItem);
			$("#deleteItem").bind("click", deleteItem);
			
			// 初始化dialog
			$("#dialog").dialog({
				autoOpen: false,
				width: 400,
				buttons: [
					{
						text: "确定",
						click: function() {
							var groupName = $("#groupName").val();
							if(groupName == null || groupName == ''){
								alert("请填写群组名！");
								return false;
							}
							var id = $("#groupId").val();
							var pId = $("#parentId").val();
							
							var type = $("#optType").val();
							if(type == "add"){
								addNode(id, pId, groupName);
							} else if(type == "edit"){
								editNode(id, groupName);
							}
						}
					},
					{
						text: "取消",
						click: function() {
							$(this).dialog("close");
						}
					}
				]
			});
			
			$("#newItemDialog").dialog({
				autoOpen: false,
				width: 600,
				buttons: [
					/* {
						text: "确定",
						click: function() {
							saveNewItem();
						}
					}, */
					{
						text: "取消",
						click: function() {
							$(this).dialog("close");
						}
					} 
				]
			});
			
			$("#newItemDialogStu").dialog({
				autoOpen: false,
				width: 670,
				buttons: [
					{
						text: "保存",
						click: function() {
							addNewItemSubmitStu();
						}
					},
					{
						text: "取消",
						click: function() {
							resetStu();
							$(this).dialog("close");
						}
					} 
				]
			});
			
			$("#editItemDialog").dialog({
				autoOpen: false,
				width: 500,
				buttons: [
					{
						text: "确定",
						click: function() {
							saveEditItem();
						}
					},
					{
						text: "取消",
						click: function() {
							$(this).dialog("close");
						}
					}
				]
			});
			
			$("#addItemBtn").click(function(){
				// 添加新成员提交检查
				preAddNewItemSubmit();
			});
			
			// 添加新成员提交检查
			function preAddNewItemSubmit(){
			
				var userId = $("#searchResultId").val();
				var phone = $("#searchResultPhone").val();
				
				$.ajax({
				   type: "POST",
				   url: "<%=basePath%>contact/preAddNewItem",
				   data: {uid:uid, userId:userId, phone:phone},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			addNewItemSubmit();
				   		} else {
				   			alert("您的通讯录中已存在该成员，请检查后重试！");
				   		}
				   }
				});
			}
			
			
		});
		
		
		/**
		* 添加群组
		*/
		function addNode(id, pId, name){
			
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>contact/addNode",
				   data: {uid:uid, id:id, pId:pId, name:name},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			window.location.href = "<%=basePath%>contact/myContacts";
				   		}
				   }
			});
		}
		
		/**
		* 修改群组名称
		*/
		function editNode(id, name){
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>contact/editNode",
				   data: {uid:uid, id:id, name:name},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			window.location.href = "<%=basePath%>contact/myContacts";
				   		}
				   }
			});
		}
		
		/**
		* 删除群组检查
		*/
		function preRemoveNode(id){
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>contact/preRemoveNode",
				   data: {uid:uid, id:id},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			removeNode(id);
				   		} else {
				   			var status = confirm("是否要删除该群组及其子项？");
				   			if(status){
				   				removeNode(id);
				   			}
				   		}
				   }
			});
		}
		
		/**
		* 删除群组
		*/
		function removeNode(id){
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>contact/removeNode",
				   data: {uid:uid, id:id},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			window.location.href = "<%=basePath%>contact/myContacts";
				   		} else {
				   			
				   		}
				   }
			});
		}
		
		function setNodeValue(id, pId, name, type){
			$("#groupId").val(id);
			$("#parentId").val(pId);
			$("#groupName").val(name);
			$("#optType").val(type);
		}
	
		/**
		* 添加新成员
		*/
		function addItem(e){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = zTree.getSelectedNodes();
			treeNode = nodes[0];
			//if (nodes.length == 0 || !nodes[0].isParent) {
			if(treeNode){
				var parentId = treeNode.parentId;
				if(parentId != null && parentId == '0'){
					alert("请先选择一个子节点");
					return;
				}
			}
			if (nodes.length == 0 || nodes[0].isGroup != 'Y') {
				alert("请先选择一个父节点");
				return;
			} else {
				var parentId = treeNode.id;
				var type = treeNode.type;
				$("#newItemType").val(type);
				$("#newItemTypeStu").val(type);
				$("#newItemParentId").val(parentId);
				$("#newItemParentIdStu").val(parentId);
				
	     	    var phoneData =  $.ajax({
					   type: "POST",
					   url: "<%=basePath%>contact/getPhoneForSearch",
					   data: {type: type},
					   dataType: 'json',
					   async: false,
					   complete: function(json){
					   		
					   }
				}).responseText;
				
				var phone = eval("("+phoneData+")"); 
				
		    	if(type == '1' || type == '3'){ // 同事
			    	$("#searchPhone").autocomplete({
				    	source: phone
				    });
		    		$("#newItemDialog").dialog("open");
		    	} else if(type == '2'){ // 学生
			    	$("#searchPhoneStu").autocomplete({
				    	source: phone
				    });
		    		$("#newItemDialogStu").dialog("open");
		    	}
			}
		}
		
		/**
		* 添加新成员
		*/
		function saveNewItem(){
			
			var newItemParentId = $("#newItemParentId").val();
			var newItemName = $("#newItemName").val();
			var newItemPhone = $("#newItemPhone").val();
			var newItemClass = $("#newItemClass").val();
			var newItemSchool = $("#newItemSchool").val();
			
			$.ajax({
				type: "post",
				url: "<%=basePath%>contact/saveNewItem",
				data: {uid:uid, parentId:newItemParentId, name:newItemName, phone:newItemPhone, classes:newItemClass, school:newItemSchool},
				dataType: 'json',
			    success: function(json){
			   		if(json.success){
			   			window.location.href = "<%=basePath%>contact/myContacts";
			   		} 
			    }
			});
		}
		
		/**
		* 初始化成员编辑form
		*/
		function initEditItemForm(id){
			
			$.ajax({
				type: "post",
				url: "<%=basePath%>contact/getContactById",
				data: {id:id},
				dataType: 'json',
				success: function(json){
					if(json.success){
						$("#editItemName").val(json.name);
						$("#editItemPhone").val(json.phone);
						$("#parentItemName").val(json.parentName);
					}
				}
			});
		}
		
		/**
		* 保存成员编辑
		*/
		function saveEditItem(){
		
			var id = $("#editItemId").val();
			var name = $("#editItemName").val();
			var phone = $("#editItemPhone").val();
			
			$.ajax({
				type: "post",
				url: "<%=basePath%>contact/saveEditItem",
				data: {uid:uid, id:id, name:name, phone:phone},
				dataType: 'json',
				success: function(json){
					if(json.success){
						window.location.href = "<%=basePath%>contact/myContacts";
					}
				}
			});
		}	
		
		/**
		* 删除成员
		*/
		function deleteContactItem(id, name){
		
			$.ajax({
				type: "post",
				url: "<%=basePath%>contact/deleteItem",
				data: {id:id},
				dataType: 'json',
				success: function(json){
					if(json.success){
						alert("删除成员【"+name+"】成功!");
						window.location.href = "<%=basePath%>contact/myContacts";
					}
				}
			});
		}
		
		function contactSearch(){
			
			var url = "<%=basePath%>contact/myContacts";
			$("#searchForm").attr("action", url).submit();
		}
		
		/**
		* 根据手机号码查询系统用户
		*/
		function searchContact(){
			
			var searchName = $("#searchName").val();
			var searchPhone = $("#searchPhone").val();
			
			if(searchPhone == null || searchPhone == ''){
				alert("手机号码不能为空！");
				return;
			}
			
			$.ajax({
			
				type: "POST",
				url: "<%=basePath%>contact/getCustomerByPhone",
				data: {searchPhone:searchPhone},
				dataType: 'json',
				success: function(json){
					if(json.success){
						var uid = json.uid;
						var name = json.name;
						var phone = json.phone;
						
						$("#searchResultTr").css("display", "");
						
						$("#searchResultName").val(name);
						$("#searchResultPhone").val(phone);
						$("#searchResultId").val(uid);
						// 查询结果不可编辑
						$("#searchResultName").attr("disabled","disabled");
						$("#searchResultPhone").attr("disabled","disabled");
					} else {
						$("#searchResultName").val("");
						$("#searchResultPhone").val("");
					}
				}
				
			});
			
		}
		
		/**
		* 根据手机号码查询系统用户
		*/
		function searchContactStu(){
			
			var searchPhoneStu = $("#searchPhoneStu").val();
			
			if(searchPhoneStu == null || searchPhoneStu == ''){
				alert("手机号码不能为空！");
				return;
			}
			
			$.ajax({
			
				type: "POST",
				url: "<%=basePath%>contact/getCustomerByPhoneStu",
				data: {searchPhoneStu:searchPhoneStu},
				dataType: 'json',
				success: function(json){
					if(json.success){
						var uid = json.uid;
						var name = json.name;
						var phone = json.phone;
						
						//$("#searchResultTrStu").css("display", "");
						$("#searchTableStu").css("display", "");
						
						$("#searchResultNameStu").val("");
						$("#searchResultParentStu").val(name);
						$("#searchResultPhoneStu").val(phone);
						$("#searchResultIdStu").val(uid);
						// 查询结果不可编辑
						$("#searchResultNameStu").removeAttr("disabled");
						$("#searchResultParentStu").attr("disabled","disabled");
						$("#searchResultPhoneStu").attr("disabled","disabled");
					} else {
						$("#searchResultNameStu").val(name);
						$("#searchResultPhoneStu").val(phone);
					}
				} 
				
			});
			
		}
		
		/**
		* 重置
		*/
		function resetStu(){
		
			$("#searchTableStu").css("display", "none");
			$("#searchPhoneStu").val("");
			$("#searchResultNameStu").val("");
			$("#searchResultParentStu").val("");
			$("#searchResultPhoneStu").val("");
		}
		
		/**
		* 添加新成员提交（同事）
		*/
		function addNewItemSubmit(){
		
			// 用户ID
			var searchResultId = $("#searchResultId").val();
			// 用户姓名
			var searchResultName = $("#searchResultName").val();
			// 用户手机号码
			var searchResultPhone = $("#searchResultPhone").val();
			// 群组ID
			var newItemParentId = $("#newItemParentId").val();
			// 群组类型
			var newItemType = $("#newItemType").val();
			
			$.ajax({
			   type: "POST",
			   url: "<%=basePath%>contact/addNewItem",
			   data: {uid:uid, userId:searchResultId, parentId:newItemParentId, name:searchResultName, phone: searchResultPhone, type: newItemType},
			   dataType: 'json',
			   success: function(json){
			   		if(json.success){
			   			window.location.href = "<%=basePath%>contact/myContacts";
			   		}
			   }
			   
			});
		}
		
		/**
		* 添加新成员提交（学生）
		*/
		function addNewItemSubmitStu(){
		
			// 用户ID
			var searchResultIdStu = $("#searchResultIdStu").val();
		    // 学生姓名
			var searchResultNameStu = $("#searchResultNameStu").val();
			if(searchResultNameStu == null || searchResultNameStu == ""){
				alert("学生姓名不能为空！");
				return false;
			}
			// 家长号码
			var searchResultPhoneStu = $("#searchResultPhoneStu").val();
			// 学生学号
			var searchResultNoStu = $("#searchResultNoStu").val();
			// 班级
			var searchResultClassStu = $("#searchResultClassStu").val();
			// 学校
			var searchResultSchoolStu = $("#searchResultSchoolStu").val();
			// 家长姓名
			var searchResultParentStu = $("#searchResultParentStu").val();
			// 群组ID
			var newItemParentIdStu = $("#newItemParentIdStu").val();
			// 群组类型
			var newItemTypeStu = $("#newItemTypeStu").val(); 
			
			$.ajax({
			   type: "POST",
			   url: "<%=basePath%>contact/addNewItemStu",
			   data: {	
			   			uid:uid, 
			   			userId:searchResultIdStu,
			   			parentId:newItemParentIdStu,
			   			sName:searchResultNameStu,
			   			phone: searchResultPhoneStu,
			   			parent: searchResultParentStu,
			   			sNo: searchResultNoStu,
			   			sClass: searchResultClassStu,
			   			sSchool: searchResultSchoolStu,
			   			type: newItemTypeStu
			   		},
			   dataType: "json",
			   success: function(json){
			   		if(json.success){
			   			window.location.href = "<%=basePath%>contact/myContacts";
			   		}
			   }
			   
			});
		}
		
		/**
		* 添加联系人记录（同事）
		*/
		function toAddNewItem(){
		
			$("#searchResultTr").css("display", "");
			$("#searchResultName").removeAttr("disabled");
			$("#searchResultPhone").removeAttr("disabled");
		}
		
		/**
		* 添加联系人记录（学生）
		*/
		function toAddNewItemStu(){
			
			//$("#searchResultTrStu").css("display", "");
			$("#searchTableStu").css("display", "");
			$("#searchResultNameStu").removeAttr("disabled");
			$("#searchResultParentStu").removeAttr("disabled");
			$("#searchResultPhoneStu").removeAttr("disabled");
		}
		
</script>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu_teacher.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<!-- <div class="breadcrumb">
	        <a class="btn orange" href="form-components.html"><i class="icon-refresh"></i></a> <a class="btn" href="form-components.html">Form Components</a>
	        <div class="pull-right">
	            <a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a class="btn" href="#">13/08/13</a>
	        </div> 
        </div> -->
        <div class="container-fluid" style="padding-top:5px;">
        	<div class="row-fluid">
				<div class="span12 well">
		        	<div class="title">
						<a href="<%=basePath%>contact/myContacts">通讯录</a> 
					</div>
				</div>
			</div>
        </div>
        <div class="container-fluid">
        	<div class=""><!-- <button id="addParent" type="button" class="btn blue">增加父节点</button> -->
        		<button type="button" id="addParent" onclick="#" class="btn blue">增加群组</button>
        		<button type="button" id="edit" onclick="#" class="btn green">编辑名称</button>
        		<button type="button" id="remove" onclick="#" class="btn red">删除群组</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		<button type="button" id="addItem" onclick="#" class="btn lightblue">添加成员</button>
        		<!-- <button type="button" id="editItem" onclick="#" class="btn lightgreen">编辑成员</button> -->
        		<button type="button" id="deleteItem" onclick="#" class="btn orange">删除成员</button>
        		<br/>
				<!-- [ <a id="addParent" href="#" title="增加群组" onclick="return false;">增加群组</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="edit" href="#" title="编辑名称" onclick="return false;">编辑名称</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="remove" href="#" title="删除群组" onclick="return false;">删除群组</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addItem" href="#" title="添加成员" onclick="return false;">添加成员</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="editItem" href="#" title="编辑成员" onclick="return false;">编辑成员</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="deleteItem" href="#" title="删除成员" onclick="return false;">删除成员</a> ] -->
				<!-- &nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addLeaf" href="#" title="增加子群组" onclick="return false;">增加子群组</a> ] -->
				<!-- &nbsp;&nbsp;&nbsp;&nbsp;[ <a id="clearChildren" href="#" title="清空子群组" onclick="return false;">清空子群组</a> ] -->
				<br/>
			</div>
        </div>
		<div class="container-fluid" style="padding-top:5px;">
            
			<div class="row-fluid">
				<div class="span4">
					<div class="span4 zTreeDemoBackground left well-content">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
				<div class="span8">
					<div class="row-fluid>
						<div class="span12 well">
							<div class="title">搜索联系人</div>
                                <div class="well-content">
                                	<fieldset>
                                    	<form id="searchForm" class="form-horizontal" method="post" action="/contact/myContacts">
	                                         <div class="control-group">
	                                             <label class="control-label"> 联系人姓名 </label>
	                                             <div class="controls">
	                                                 <input id="searchName" name="searchName" type="text" placeholder="联系人姓名" class="input span4">&nbsp;&nbsp;
	                                                 <!-- <button type="button"  onclick="contactSearch();" class="btn blue">搜索</button> -->
			                                         <span id="searchBtn" class="btn blue" onclick="contactSearch();">
														<i class="icon-search"></i> 搜索
													</span> 
	                                             </div>
	                                         </div>
                                        </form>
                                        <div class="title">联系人列表</div>
	                        			<div class="well-content">
	                            			<table class="table table-striped table-bordered" id="managed-table">
				                                <thead>
				                                    <tr>
				                                    	<th>序号</th>
				                                        <th>联系人姓名</th>
				                                        <th>联系人手机号码</th>
				                                        <th>分类</th>
				                                    </tr>
				                                </thead>
				                                <tbody>
				                                	<c:forEach items="${myContactList}" var="contact" varStatus="c">
					                                	<tr class="odd gradeX">
					                                		<td class="center">${c.index+1}</td>
					                                        <td>${contact.name}</td>
					                                        <td>${contact.phone}</td>
					                                        <td class="center">
					                                        	<c:if test="${contact.type eq '1'}">同事</c:if>
					                                        	<c:if test="${contact.type eq '2'}">学生</c:if>
					                                        	<c:if test="${contact.type eq '3'}">个人</c:if>
					                                        </td>
					                                    </tr>
				                                	</c:forEach>
				                                </tbody>
	                            			</table>
				                            <form action="<%=basePath%>contact/myContacts" method="post" id="myContactList"></form>
											<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="myContactList"/>  
				                        </div>
                                    </fieldset>
                                </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<!-- 群组名称编辑dialog start -->
		<div id="dialog" title="群组名称">
			<input class="input" type="text" id="groupName" name="groupName" value="" placeholder="填写名称"/>
			<input type="hidden" id="optType" name="optType"/>
			<input type="hidden" id="groupId" name="groupId"/>
			<input type="hidden" id="parentId" name="parentId"/>
		</div>
		<!-- 群组名称编辑dialog end -->
		
		<!-- 联系人新增dialog For Tea start-->
		<div id="newItemDialog" title="添加联系人">
			<form id="contactSearchForm">
				<div class="well-content" style="padding-bottom:10px;">
                  	手机号码
                   <input id="searchPhone" name="searchPhone" type="text" placeholder="" class="span2">&nbsp;&nbsp;
                   <span class="btn lightblue" onclick="searchContact();">
						<i class="icon-search"></i> 查询 
				   </span>
                   <!-- <button id="searchBtn" type="button" class="btn lightblue" onclick="searchContact();">查询</button> -->
                </div>
                <p class="help-block">
                  	 <span style="color:red;">注：</span> 可根据同事手机号码查询同事信息，也可点击【新增】按钮直接进行添加
                </p>
                <div id="managed-table_filter">
					<span class="btn blue" onclick="toAddNewItem();">
						<i class="icon-edit"></i> 新增 
					</span> 
				</div>
                <div class="well-content" style="padding-top:5px;">
	                <table class="table table-striped table-bordered" id="searchTable">
	                    <thead>
	                        <tr>
	                            <th>联系人姓名</th>
	                            <th>手机号</th>
	                            <th>操作</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<tr id="searchResultTr" class="odd gradeX" style="display:none;">
                               <td><input type="text" id="searchResultName" name="searchResultName" class="span2" disabled /></td>
                               <td><input type="text" id="searchResultPhone" name="searchResultPhone" class="span2" disabled /></td>
                               <td class="center">
                               	<input type="hidden" id="searchResultId" name="searchResultId"/>
                               	<input type="hidden" id="newItemParentId" name="newItemParentId"/>
                               	<input type="hidden" id="newItemType" name="newItemType"/>
                               	<button id="addItemBtn" type="button" class="btn btn-primary">添加</button>
                               </td>
                           </tr>
	                    </tbody>
	                </table>
	            </div>
			</form>
		</div>
		<!-- 联系人新增dialog For Tea end-->	
		
		<!-- 联系人新增dialog For Stu start -->
		<div id="newItemDialogStu" title="添加联系人">
			<form id="contactSearchFormStu">
				<div class="well-content" style="padding-bottom:10px;">
                  	手机号码
                   <input id="searchPhoneStu" name="searchPhoneStu" type="text" placeholder="" class="span2">&nbsp;&nbsp;
                   <span class="btn lightblue" onclick="searchContactStu();">
						<i class="icon-search"></i> 查询 
				   </span>
                </div>
                <p class="help-block">
                  	 <span style="color:red;">注：</span> 可根据家长手机号码查询家长信息，也可点击【新增】按钮直接进行添加
                </p>
                <div id="managed-table_filter">
					<span class="btn blue" onclick="toAddNewItemStu();">
						<i class="icon-edit"></i> 新增 
					</span> 
				</div>
	            <div class="well-content" style="padding-top:10px;">
	                <table class="table table-striped table-bordered" id="searchTableStu" style="display:none;">
	                	<tr>
	                		<td>家长姓名</td>
	                		<td><input type="text" id="searchResultParentStu" name="searchResultParentStu" class="span2" disabled /></td>
	                		<td>家长手机号</td>
	                		<td><input type="text" id="searchResultPhoneStu" name="searchResultPhoneStu" class="span2" disabled /></td>
	                		<input type="hidden" id="searchResultIdStu" name="searchResultIdStu"/>
                            <input type="hidden" id="newItemParentIdStu" name="newItemParentIdStu"/>
                            <input type="hidden" id="newItemTypeStu" name="newItemTypeStu"/>
	                	</tr>
	                	<tr>
	                		<td>学生学号</td>
	                		<td><input type="text" id="searchResultNoStu" name="searchResultNoStu" class="span2" /></td>
	                		<td>学生姓名</td>
	                		<td><input type="text" id="searchResultNameStu" name="searchResultNameStu" class="span2" /></td>
	                	</tr>
	                	<tr>
	                		<td>班级</td>
	                		<td colspan="3"><input type="text" id="searchResultClassStu" name="searchResultClassStu" class="span4" /></td>
	                	</tr>
	                	<tr>
	                		<td>学校</td>
	                		<td colspan="3"><input type="text" id="searchResultSchoolStu" name="searchResultSchoolStu" class="span4" /></td>
	                	</tr>
	                </table>
	            </div>
			</form>
		</div>
		<!-- 联系人新增dialog For Stu end -->
		
	<%@include file="/page/layout/html_copyright.jsp"%>
	<%@include file="/page/layout/html_footer_tables.jsp"%>

</body>
</html>