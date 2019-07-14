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
<title>Редактирование группы</title>
</head>
<body>
<c:set var="gruppa" value="${form.eg}" />

<div class="form-style-10">
<h1><a href="WebControlGruppa">Группа оборудования</a><span>Редактирование</span></h1>
<form method="get">
<input type="hidden" name="gruppaId" value="${gruppa.gruppaId}">
    <div class="section"><span>&#9998</span>Группа оборудования</div>
    <div class="inner-wrap">
        <label>название<input type="text" name="name"  value="${gruppa.name}" /></label>
        <label>примечание<input type="text" name="note" value="${gruppa.note}"/></label>
    </div>
     <div class="button-section">
		<button type="submit" formaction="WebControlGruppa" name="action"
			value="${form.action}">Сохранить изменения</button>
	</div>
</div>
   
</form>
</div>


</body>
</html>