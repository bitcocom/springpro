<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC01</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>Spring MVC01</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
       <table class="table">
          <tr>
            <td>제목</td>
            <td>${vo.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td>${fn:replace(vo.content,newLineChar,"<br/>")}</td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>${vo.writer}</td>
          </tr>
          <tr>
            <td>작성일</td>
            <td>${fn:split(vo.indate," ")[0]}</td>
          </tr>
          <tr>
           <td colspan="2" align="center">
             <a class="btn btn-primary btn-sm">수정화면</a>
             <a href="boardDelete.do/${vo.idx}" class="btn btn-warning btn-sm">삭제</a>
             <a href="boardList.do" class="btn btn-info btn-sm">목록</a>
           </td>
          </tr>
       </table>    
    </div>
    <div class="panel-footer">인프런_스프1탄_박매일</div>
  </div>
</div>

</body>
</html>