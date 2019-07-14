<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
<%@ include file='css/edit-form.css' %>
</style>
<title>Редактирование ответственного</title>
</head>
<body>
<c:set var="otv" value="${form.ovetst}" />
<c:set var="otdels" value="${form.otdel}"/>
<c:set var="posts" value="${form.post }"/> 

<div class="form-style-10">
<h1><a href="WebControlOtv">Ответственный</a><span>Редактирование</span></h1>
<form method="get">
<input type="hidden" name="otvId" value="${otv.otvId}">
<input type="hidden" name="personnelId" value="${otv.personnelId}">

    <div class="section"><span>&#9998</span>ответственные</div>
    <div class="inner-wrap">
        <label>Фамилия<input type="text" name="surname"  value="${otv.surname}" /></label>
   
   
        <label>Имя<input type="text" name="name"  value="${otv.name}" /></label>
   
   
        <label>Отчество<input type="text" name="patronymic"  value="${otv.patronymic}" /></label>
   
   
        <label>Телефон<input type="text" name="phon"  value="${otv.phon}" /></label>
        <label>Отдел
   <select name="otdelId" >
    <c:forEach items="${otdels}" var="otdel">
							<c:if test="${otdel.otdelId eq otv.otdelId}">
								<option value="${otdel.otdelId}" selected="selected"><c:out
										value="${otdel.name}" ></c:out></option>
							</c:if>
							<c:if test="${otdel.otdelId ne otv.otdelId}">
								<option value="${otdel.otdelId}"><c:out
										value="${otdel.name}" ></c:out></option>
							</c:if>
	 </c:forEach>
	 </select>
	 </label>
	 
	 <label>Должность
   <select name="postId" >
    <c:forEach items="${posts}" var="post">
							<c:if test="${post.postId eq otv.postId}">
								<option value="${post.postId}" selected="selected"><c:out
										value="${post.name}" ></c:out></option>
							</c:if>
							<c:if test="${post.postId ne otv.postId}">
								<option value="${post.postId}"><c:out
										value="${post.name}" ></c:out></option>
							</c:if>
	 </c:forEach>
	 </select>
	 </label>
	 
	 
        
    </div>
     <div class="button-section">
		<button type="submit" formaction="WebControlOtv" name="action"
			value="${form.action}">Сохранить изменения</button>
	</div>
</div>
   
</form>
</div>


</body>
</html>