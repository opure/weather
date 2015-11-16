<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="page" uri="/tag/pager.tld" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目管理</title>
 <%@include file="/page/layout/html_header.jsp"%>
</head>
<body>
 		<%@include file="/page/layout/html_navbar.jsp"%>
        <!-- /.navbar -->
        <!-- /.menu-inner -->
        <%@include file="/page/layout/html_menu.jsp"%>
        <div class="page-wrap">
        <div class="breadcrumb">
                <a class="btn orange" href="tables.html"><i class="icon-refresh"></i></a> <a class="btn" href="tables.html">Data Tables</a>
                <div class="pull-right">
                    <a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a class="btn" href="#">13/08/13</a>
                </div>
            </div>
       <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12 well">
                        <div class="title">栏目管理</div>
                        <div class="well-content ">
                          <div class="col-md-6 col-md-offset-6" id="managed-table_filter" >
                          <label>Search: <input type="text"></label>
                          </div>
                        </div>
                          <table class="table table-striped table-bordered dataTable" id="managed-table">
                                <thead>
                                    <tr>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 160px;">ID</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 267px;">栏目名称</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 150px;">上级栏目</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 200px;">APP名称</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 106px;">栏目类型</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 106px;">内部模块</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 106px;">排序</th>
                                    <th class="sorting"  rowspan="1" colspan="1"  style="width: 170px; text-align:center">操作</th>
                                    </tr>
                                </thead>
                            <tbody >
                            <c:forEach items="${columnList}" var="col">
                               <tr>
                                    <td class=" sorting_1">${col.id}</td>
                                    <td class=" ">${col.name }</td>
                                    <td class=" ">${col.parentId }</td>
                                    <td class="center ">${col.app.title}</td>
                                    <td class="center ">${col.type}</td>
                                    <td class="center ">${col.module }</td>
                                    <td class="center ">${col.orderBy }</td>
                                    <td>
                                    <button type="button" class="btn blue">修改</button>
                                    <button type="button" class="btn red">删除</button>
                                    </td>
                              </tr>
                              </c:forEach>
                               </tbody>
                               </table>
                               <form action="<%=basePath%>column/allColumn" method="post" id="all"></form>
						      <page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="all"/>  
                                    <div class="pagination pagination-centered">
                                            <ul>
                                                <li><a href="#">Prev</a></li>
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                                <li><a href="#">4</a></li>
                                                <li><a href="#">Next</a></li>
                                            </ul>
                                        </div>
                             </div>
                        </div>
                    </div>
                </div>
          
          
       		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>  
          
          
                
</body>
</html>  