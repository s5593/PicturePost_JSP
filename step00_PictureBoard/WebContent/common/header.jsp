<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>

<link rel="StyleSheet" 
href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<script 
src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<h1>Share the Picture!!!</h1>
<div class="navbar navbar-default" style="margin: 5px">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
  </div>
  <div class="navbar-collapse collapse navbar-responsive-collapse">
    <ul class="nav navbar-nav">
      	<li><a href="${pageContext.request.contextPath}/postView/human.jsp">Human</a></li>
    	<li><a href="${pageContext.request.contextPath}/postView/animal.jsp">Animal</a></li>
    	<li><a href="${pageContext.request.contextPath}/postView/scenery.jsp">scenery</a></li>  
     </ul>
	     <ul class="nav navbar-nav navbar-right">
	     <c:choose>
	     <c:when test="${loginUser==null}">
	        <li><a href="${pageContext.request.contextPath}/user/login.jsp" class="btn btn-danger">Login</a></li>
	       </c:when>
	        <c:otherwise>
	     		<li class="active"><a href="${pageContext.request.contextPath}/user/login.jsp">${loginUser}</a></li>
	      		<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout" class="btn btn-danger">Logout</a></li>
	    		 
     	</c:otherwise>
     </c:choose>
     </ul>    
  </div>
</div>
<span style="font-size:20pt;">&lt;<a href="${path}/postView/write.jsp">글쓰기</a>&gt;</span>



