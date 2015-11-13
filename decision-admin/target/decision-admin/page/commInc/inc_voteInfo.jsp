<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
// 投票类型
final Map<Integer,String> voteType = new HashMap<Integer,String>();
voteType.put(0, "单选");
voteType.put(1, "多选");

pageContext.setAttribute("_voteType", voteType);

// 是否开放
final Map<Integer,String> publish = new HashMap<Integer,String>();
publish.put(0, "是");
publish.put(1, "否");

pageContext.setAttribute("_publish", publish);

%>

