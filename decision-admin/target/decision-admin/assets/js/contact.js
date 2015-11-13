
		
		
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}
		
		function edit() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if(treeNode){
				var parentId = treeNode.parentId;
				if(parentId != null && parentId == '0'){
					alert("请先选择一个子节点");
					return;
				}
			}
			//alert(treeNode.name+", "+treeNode.id);
			if (nodes.length == 0 || nodes[0].isGroup != 'Y') {
				alert("请先选择一个父节点");
				return;
			}
			setNodeValue(treeNode.id, null, treeNode.name, "edit");
			//zTree.editName(treeNode);
			$("#dialog").dialog("open");
		};
		
		function remove(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0) {
				alert("请先选择一个节点");
				return;
			}
			preRemoveNode(treeNode.id);
			//var callbackFlag = $("#callbackTrigger").attr("checked");
			//zTree.removeNode(treeNode, callbackFlag);
		};
		function clearChildren(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0 || !nodes[0].isParent) {
				alert("请先选择一个父节点");
				return;
			}
			zTree.removeChildNodes(treeNode);
		};
		
		function editItem(e){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			if (nodes.length == 0 || nodes[0].isParent) {
				alert("请先选择一个子节点");
				return;
			} else {
				var id = treeNode.id;
				var name = treeNode.name;
				$("#editItemId").val(id);
				$("#editItemDialog").dialog("open");
				initEditItemForm(id);
			}
		};
		function deleteItem(e){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = zTree.getSelectedNodes();
			treeNode = nodes[0];
			if (nodes.length == 0 || nodes[0].isParent) {
				alert("请先选择一个子节点");
				return;
			} else {
				var id = treeNode.id;
				var name = treeNode.name;
				confirm("确认要删除该成员？", deleteContactItem(id, name));
			}
		};
		
		var newCount = 1;
		function add(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			isParent = e.data.isParent,
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
			//alert(treeNode.id);
			if (treeNode) {
				var isGroup = treeNode.isGroup;
				var pId = treeNode.pId;
				var parentId = treeNode.parentId;
				
				if(parentId != null && parentId == '0'){ // 群组下不允许添加小组
					var treeNodeId = treeNode.id;
					setNodeValue(null, treeNodeId, null, "add");
					
					$("#dialog").dialog("open");
				} else {
					alert("请先选择一个父节点");
				}
				
				//treeNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
			} else {
				setNodeValue(null, null, null, "add");
				$("#dialog").dialog("open");
				//treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:"new node" + (newCount++)});
			}
			/* if (treeNode) {
				zTree.editName(treeNode[0]);
			} else {
				alert("叶子节点被锁定，无法增加子节点");
			} */
		};
		
		
		
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
		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}