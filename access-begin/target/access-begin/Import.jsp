<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%-- <%@ include file='css/table1.css' %> --%>

<%-- <%@ include file='css/hide.css' %> --%>
<%-- <%@ include file='css/button-sort.css' %> --%>
<%-- <%@ include file='css/view-form.css' %> --%>
<%--  <%@include file='css/slide-top-panel.css' %> --%>
 <%@ include file='css/edit-form.css' %>

</style>
<title>Insert title here</title>
</head>
<body>
<c:import url="nav.jsp" />

<div class="form-style-10">
<h1>Материальные средства<span>просмотр</span></h1>
<!-- enctype="multipart/form-data" -->
<form method="post" enctype="multipart/form-data">
 <div class="section"><span>&#9998</span>Выберите файл</div>
	<div class="inner-wrap">
	
			<label>Укажите файл для загрузки<input type="file" name="pathimport" /></label>
	</div>


	<div class="button-section">

		<button type="submit" formaction="WebControlImport" name="action"
			value="import">Загрузить</button>

	</div>
	</form>
	
<form method="post">
	<div class="section">
		<span>&#9998</span>Загруженные материальные средства
	</div>
	<div class="inner-wrap">
	<table>
	<tr><th></th><th>название</th><th>инв. номер</th><th>дата ввода</th><th>группа</th></tr>
	<c:forEach items="${em}" var="row" varStatus="status">
						<tr>
						   <td><input type="checkbox" name="checkbox_${status.index}" value="${status.index}">
						   </td>
							<td width="50%"><input type="text" name="name_${status.index}" value="${row.name }"></td>
							<td><input type="text" name="invnumber_${status.index}"
								value="${row.invnumber }"></td>
							<fmt:parseDate var="datebegin" value="${row.matDateBegin}"
								pattern="yyyy-MM-dd">
							</fmt:parseDate>
							<fmt:formatDate var="datebegin" value="${datebegin}"
								pattern="yyyy-MM-dd" />
							<td><input type="date" name="matDateBegin_${status.index}"
								value="${datebegin}" /></td>
							<td><select name="gruppa_id_${status.index}">
									<c:forEach items="${listgruppa}" var="gruppa">

										<option value="${gruppa.gruppaId}"><c:out
												value="${gruppa.name} "></c:out></option>
									</c:forEach></td>
						</tr>
					</c:forEach>
	</table>
	
	</div>
	<div class="button-section">

		<button type="submit" formaction="WebControlImport" name="action"
			value="load">Импорт</button>
	</div>
</form>
</div>


</body>	
	
	</html>