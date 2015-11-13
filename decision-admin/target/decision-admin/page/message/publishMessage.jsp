<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../commInc/inc_msgInfo.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
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
<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">

		var uid = '${uid}';
		
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true
			},
			data: { //利用 setting.data.keep.parent / leaf 属性 实现了父节点、叶子节点的状态锁定
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onCheck: onCheck
			}
		};

		function beforeClick(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.checkNode(treeNode, !treeNode.checked, null, true);
			return false;
		}
		
		function onCheck(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getCheckedNodes(true),
			v = "";
			ids = "";
			for (var i=0, l=nodes.length; i<l; i++) {
				
				if(nodes[i].isGroup != 'Y'){
					var isGroup = nodes[i].isGroup;
					if(isGroup != ''){
						v += nodes[i].name + ", ";
						ids += nodes[i].id + ",";
						//ids += nodes[i].contactId + ",";
					}
				} 
			} 
			
			//v += treeNode.name + ",";
			if (v.length > 0 ) v = v.substring(0, v.length-2);
			if (ids.length > 0 ) ids = ids.substring(0, ids.length-1);
			var repbj = $("#recipient");
			repbj.attr("value", v);
			$("#recipients").val(ids);
		}
		
		function checkNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type = e.data.type,
			nodes = zTree.getSelectedNodes();
			if (type.indexOf("All")<0 && nodes.length == 0) {
				alert("请先选择一个节点");
			}

			if (type == "checkAllTrue") {
				zTree.checkAllNodes(true);
			} else if (type == "checkAllFalse") {
				zTree.checkAllNodes(false);
			} 
			
			nodes = zTree.getCheckedNodes(true),
			v = "";
			for (var i=0, l=nodes.length; i<l; i++) {
				
				if(nodes[i].isGroup != 'Y'){
					v += nodes[i].name + ",";
				}
				
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var repbj = $("#recipient");
			repbj.attr("value", v);
		}
		
		function showTree(typeId){
			var treeData = "";
			
			$.ajax({
				type: "POST",
				url: "<%=basePath%>teacher/getContactTree",
				data: {uid:uid, typeId:typeId},
				dataType: 'json',
				success: function(json){
					
					var zNodes = json;
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
					$("#dialog").dialog("open");
					var repObj = $("#recipient");
					var repOffset = $("#recipient").offset();
					//$("#dialog").css({left:repOffset.left + "px", top:repOffset.top + repObj.outerHeight() + "px"}).slideDown("fast");
					//$("#dialog").addClass("zTreeDemoBackground left well-content");
				}
			});
			
			return treeData;
		}
		
		/**
		* 初始化信息模板
		*/
		function initMessageTemplate(id){
		
			$.ajax({
				type: "POST",
				url: "<%=basePath%>message/getMessageTemplateById",
				data: {id:id},
				dataType: "json",
				success: function(json){
				
					$("#title").val(json.msgTemplateTitle);
					$("#summary").val(json.msgTemplateSummary);
					$("#content").html(json.msgTemplateContent);
				}
			});
		}
		
		$(document).ready(function(){
			
			// 初始化dialog
			$("#dialog").dialog({
				autoOpen: false,
				width: 400,
				buttons: [
					{
						text: "确定",
						click: function() {
							$(this).dialog("close");
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
			
			$("#checkAllTrue").bind("click", {type:"checkAllTrue"}, checkNode);
			$("#checkAllFalse").bind("click", {type:"checkAllFalse"}, checkNode);
			
			// 发送模式切换
			$("input:radio[name='sendMode']").change(function(){
				var mode = $("input[name='sendMode']:checked").val();
				if(mode == 2) { // 定时发送
					$("#timingDiv").css("display", "");
				} else {
					$("#timingDiv").css("display", "none");
				}
			});
			
			$("#formSubmit").click(function(){
				var recipients = $("#recipients").val();
				if(recipients != null && recipients != ''){
					var url = "<%=basePath%>message/sendMessage";
					$("#publishMessageForm").attr("action", url).submit();
				} else {
					alert("请选择收件人！");
				}
				
			});
			
			
			$("#isBroadcastCheckbox").click(function(){
				
				if($("#isBroadcastCheckbox").is(":checked")){
					$("#groupBar").css("display", "none");
					$("#recipients").val("0");
					$("#recipient").val("All");
				} else {
					$("#groupBar").css("display", "");
					$("#recipients").val("");
					$("#recipient").val("");
				}
				
			});
		});
		
</script>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu_teacher.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						<ul class="nav nav-tabs">
                           	<li class="heading"></li>
							<li>
								<a href="<%=basePath%>message/sentMessageMgt" >
									已发信息列表
								</a>
							</li>
							<li class="active">
								<a href="#" data-toggle="tab">
									发送信息
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						<form class="form-horizontal" id="publishMessageForm" name="publishMessageForm" 
							action="#" method="post">
							<fieldset>
								<div class="control-group">
									<label class="control-label">发件人</label>
									<div class="controls">
										<input id="publisherName" name="publisherName" type="text" disabled
											placeholder="" value="${publisherName}" class="input span3" />
									</div>
									<input type="hidden" id="publisherId" name="publisherId" value="${uid}" />
								</div>
								<div class="control-group">
									<label class="control-label">收件人</label>
									<div class="controls">
										<input id="recipient" name="recipient" type="text"
											placeholder="请选择收件人" class="input span6" />&nbsp;&nbsp;
										<span id="groupBar">
											<c:forEach items="${contactTypeList}" var="contactType" varStatus="ct">
												<button id="contactTypeBtn_${ct.index}" type="button" onclick="showTree('${contactType.typeId}');" 
												class="btn <c:forEach items='${_btnColor}' var='color'>
																<c:if test='${ct.index == color.key }'>${color.value}</c:if>
														   </c:forEach>">${contactType.typeName}</button>&nbsp;&nbsp;
											</c:forEach>
										</span>
										<label class="checkbox">
                                            <div class="checker" style="padding-top:6px;">
                                                <span>
                                                	<input type="checkbox" id="isBroadcastCheckbox" value="">
                                                </span>
                                            </div>
                                            	是否广播
                                        </label>
										<input type="hidden" id="recipients" name="recipients"/>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">信息类型 </label>
									<div class="controls">
										<c:forEach items="${_msgType}" var="msgType" varStatus="m">
											<input type="radio" name="type" value="${msgType.key}"/>&nbsp;${msgType.value}&nbsp;&nbsp;
										</c:forEach>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">选择模板</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<select id="msgTemplate" name="msgTemplate" class="input span3" onchange="initMessageTemplate(this.value);">
                                    			<option value="">请选择信息模板</option>
                                    			<c:forEach items="${msgTemplateList}" var="msgTemplate" varStatus="mt">
                                    				<option value="${msgTemplate.uid}">${msgTemplate.title}</option>
                                    			</c:forEach>
											</select>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">信息内容</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" name="title" class="wmd-input span6" placeholder="请填写信息标题" id="title"/>（标题）
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"></label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" name="summary" class="wmd-input span6" placeholder="请填写信息概要" id="summary"/> （概要）
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"></label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" id="content" name="content"
                                    		 class="wmd-input span6" placeholder="请填写信息内容" id="wmd-input"></textarea> （内容）
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">发送模式</label>
									<div class="controls">
										<c:forEach items="${_sendMode}" var="sendMode" varStatus="sm">
											<input type="radio" name="sendMode" value="${sendMode.key}" <c:if test='${sendMode.key eq 1}'>checked='checked'</c:if> />&nbsp;${sendMode.value}&nbsp;&nbsp;
										</c:forEach>
										<div id="timingDiv" class="input-append date form_datetime" style="display:none;">
										    <input size="16" class="span10" type="text" id="pubTime" name="pubTime" value="" readonly>
										    <span class="add-on"><i class="icon-th"></i></span>
										</div>									
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"> </label>
									<div class="controls">
										<button id="formSubmit" type="button" class="btn btn-success">发送</button> &nbsp;&nbsp;
										<button type="button" class="btn">重置</button>
									</div>
								</div>
								<!-- ui-dialog -->
								<div id="dialog" title="收件人" class="zTreeDemoBackground left well-content">
									<p>[ <a id="checkAllTrue" href="#" title="全选" onclick="return false;">全选</a> ]
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="checkAllFalse" href="#" title="取消全选" onclick="return false;">取消全选</a> ]
									</p>
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	
	<script type="text/javascript">
			
	    $(".form_datetime").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true,
	        //pickerPosition: "bottom-left"
	        pickerPosition: "top-right"
	    });
	</script>   
</body>
</html>