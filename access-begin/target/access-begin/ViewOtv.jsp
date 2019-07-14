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


<title>Ответственные</title>
</head>
<body>
<%-- <c:import url="FrameFilterMaterial.jsp"  var="framefilter" scope="request"></c:import> --%>
<c:import url="PanelFilter.jsp"/>
	<c:import url="nav.jsp" />
		<div class="form-style-10">
<h1>Ответственные<span>просмотр</span></h1>
 <div class="section"><span>&#9998</span>Ответственные</div>
 <div class="inner-wrap">
	<form>
		<table>
			
				<th>ФИО<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=name&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=name&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>
				<th>паспорт<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=PASSPORT_NUMBER&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=PASSPORT_NUMBER&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>
				
				<th>телефон<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=PHON&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=PHON&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>
				
				<th>должность<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=POST_NAME&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlOtv?action=view&sort=POST_NAME&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>
				

				
				<c:set var="otv" value="${form.entityOtv}" />
				<c:forEach items="${otv}" var="row" varStatus="status">
					<tr>


						<td><input type="checkbox" id="hd-${status.index}" class="hide" /> 
						<label for="hd-${status.index}"><c:out value="${row.surname} ${row.name} ${row.patronymic}" /></label>
							<div> 
								<div>
									<input type="radio" name="row" id="label-${row.otvId}"
										value="${row.otvId}"> 
									<input type="checkbox" name="checkrow" value="${row.personnelId}">
								</div>
								<div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlOtv"
											name="action" value="edit">Редактировать</button>
									</div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlOtv"
											name="action" value="insert">Добавить</button>
									</div>

									<div class="panel-button">
										<button type="submit" formaction="WebControlOtv"
											name="action" value="delete">Удалить</button>
									</div>
								</div>
							</div></td>
							<td><c:out value="${row.passportNumber}" /></td>
							<td><c:out value="${row.phon}" /></td>
							<td><c:out value="${row.postName}" /></td>
							
					</tr>
				</c:forEach>
			
		</table>
	</form>
	</div>
	</div>
</body>
</html>