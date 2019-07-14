<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file='css/table1.css' %>

<%@ include file='css/hide.css' %>
<%@ include file='css/button-sort.css' %>
<%@ include file='css/view-form.css' %>
</style>


<title>Учет материальных запасов</title>
</head>
<body>
<%-- <c:import url="FrameFilterMaterial.jsp"  var="framefilter" scope="request"></c:import> --%>
<c:import url="PanelFilter.jsp"/>
	<c:import url="nav.jsp" />
	<div class="form-style-10">
<h1>Отделы<span>просмотр</span></h1>
 <div class="section"><span>&#9998</span>отделы</div>
    <div class="inner-wrap">
	<form>
		<table>
			
				<th>название<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlOtdel?action=view&sort=name&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlOtdel?action=view&sort=name&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>

				
				<c:set var="otdel" value="${form.entityOtdel}" />
				<c:forEach items="${otdel}" var="row" varStatus="status">
					<tr>


						<td><input type="checkbox" id="hd-${status.index}" class="hide" /> 
						<label for="hd-${status.index}"><c:out value="${row.name}" /></label>
							<div> 
								<div>
									<input type="radio" name="row" id="label-${row.otdelId}"
										value="${row.otdelId}"> <input type="checkbox"
										name="checkrow" value="${row.otdelId}">
								</div>
								<div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlOtdel"
											name="action" value="edit">Редактировать</button>
									</div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlOtdel"
											name="action" value="insert">Добавить</button>
									</div>

									<div class="panel-button">
										<button type="submit" formaction="WebControlOtdel"
											name="action" value="delete">Удалить</button>
									</div>
								</div>
							</div></td>
					</tr>
				</c:forEach>
			
		</table>
	</form>
	</div>
	</div>
</body>
</html>