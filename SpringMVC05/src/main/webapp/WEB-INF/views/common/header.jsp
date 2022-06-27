<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextPath}/">스프1탄</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/">Home</a></li>
        <li><a href="boardMain.do">게시판</a></li>            
      </ul>
      <c:if test="${empty mvo}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${contextPath}/memLoginForm.do"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	            <li><a href="${contextPath}/memJoin.do"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>            
	      </ul>
      </c:if>
      <c:if test="${!empty mvo}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${contextPath}/memUpdateForm.do"><span class="glyphicon glyphicon glyphicon-wrench"></span> 회원정보수정</a></li>
	            <li><a href="${contextPath}/memImageForm.do"><span class="glyphicon glyphicon glyphicon-picture"></span> 사진등록</a></li>
	            <li><a href="${contextPath}/memLogout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>            
	            <c:if test="${!empty mvo}">
			    <c:if test="${empty mvo.memProfile}">
			      <li><img class="img-circle" src="${contextPath}/resources/images/person.PNG" style="width: 50px; height: 50px"/> ${mvo.memName} 님
			      (
			       <c:forEach var="authVO" items="${mvo.authList}">
			          <c:if test="${authVO.auth eq 'ROLE_USER'}">U</c:if>
			          <c:if test="${authVO.auth eq 'ROLE_MANAGER'}">M</c:if>
			          <c:if test="${authVO.auth eq 'ROLE_ADMIN'}">A</c:if>
			       </c:forEach>			      
			       )Welcome.</li>
			    </c:if>
			    <c:if test="${!empty mvo.memProfile}">
			      <li><img class="img-circle" src="${contextPath}/resources/upload/${mvo.memProfile}" style="width: 50px; height: 50px"/> ${mvo.memName} 님
			      (
			      <c:forEach var="authVO" items="${mvo.authList}">
			          <c:if test="${authVO.auth eq 'ROLE_USER'}">U</c:if>
			          <c:if test="${authVO.auth eq 'ROLE_MANAGER'}">M</c:if>
			          <c:if test="${authVO.auth eq 'ROLE_ADMIN'}">A</c:if>
			      </c:forEach>	
			      )Welcome.</li>
			    </c:if>			  
			  </c:if>
	      </ul>
      </c:if>
    </div>
  </div>
</nav>