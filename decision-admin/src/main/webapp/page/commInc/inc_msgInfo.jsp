<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
final Map<Integer,String> btnColor = new HashMap<Integer,String>();
btnColor.put(0,"green");
btnColor.put(1,"lightblue");
btnColor.put(2,"lightgreen");
btnColor.put(3,"blue");
btnColor.put(4,"pink");
btnColor.put(5,"orange");
btnColor.put(6,"purple");
btnColor.put(7,"red");
btnColor.put(8,"yellow");
btnColor.put(9,"grey");

pageContext.setAttribute("_btnColor", btnColor);

final Map<Integer,String> msgType = new HashMap<Integer,String>();
msgType.put(1, "作业");
msgType.put(2, "通知");
msgType.put(3, "成绩");

pageContext.setAttribute("_msgType", msgType);

final Map<Integer,String> sendMode = new HashMap<Integer,String>();
sendMode.put(1, "立即发送");
sendMode.put(2, "定时发送");

pageContext.setAttribute("_sendMode", sendMode);

%>

