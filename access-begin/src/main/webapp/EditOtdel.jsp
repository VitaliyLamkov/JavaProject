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
<title>Редактирование отдела</title>
</head>
<body>
<c:set var="otdel" value="${form.otdel}" />

<div class="form-style-10">
<h1><a href="WebControlOtdel">Отделы</a><span>Редактирование</span></h1>
<form method="get">
<input type="hidden" name="otdelId" value="${otdel.otdelId}">
    <div class="section"><span>&#9998</span>Отделы</div>
    <div class="inner-wrap">
        <label>название<input type="text" name="name"  value="${otdel.name}" /></label>
    </div>
     <div class="button-section">
		<button type="submit" formaction="WebControlOtdel" name="action"
			value="${form.action}">Сохранить изменения</button>
	</div>
</div>
   
</form>
</div>


</body>
</html>