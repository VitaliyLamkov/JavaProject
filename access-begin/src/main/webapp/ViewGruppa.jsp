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


<title>Группы оборудования</title>
</head>
<body>
<%-- <c:import url="FrameFilterMaterial.jsp"  var="framefilter" scope="request"></c:import> --%>
<c:import url="PanelFilter.jsp"/>
	<c:import url="nav.jsp" />
	<div class="form-style-10">
<h1>Группы оборудования<span>просмотр</span></h1>
 <div class="section"><span>&#9998</span>группы оборудования</div>
    <div class="inner-wrap">
	<form>
		<table>
			<tr>
			
				<th>название<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlGruppa?action=view&sort=name&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlGruppa?action=view&sort=name&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>

				<th>примечание<br>
					<div class="panel-button">
						<div class="panel-button">
							<a href="WebControlGruppa?action=view&sort=note&order=asc"
								class="button13">&#11014</a>
						</div>
						<div class="panel-button">
							<a href="WebControlGruppa?action=view&sort=note&order=desc"
								class="button13">&#11015</a>
						</div>
					</div>
				</th>
				<c:set var="gr" value="${form.entityGruppa}" />
				
				<c:forEach items="${gr}" var="row" varStatus="status">
					<tr>


						
						<td>
						<input type="checkbox" id="hd-${status.index}" class="hide" /> 
						<label for="hd-${status.index}"><c:out 	value="${row.name}" /></label>
							<div>
								<div>
									<input type="radio" name="row" id="label-${row.gruppaId}"
										value="${row.gruppaId}"> <input type="checkbox"
										name="checkrow" value="${row.gruppaId}">
								</div>
								<div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlGruppa"
											name="action" value="edit">Редактировать</button>
									</div>
									<div class="panel-button">
										<button type="submit" formaction="WebControlGruppa"
											name="action" value="insert">Добавить</button>
									</div>

									<div class="panel-button">
										<button type="submit" formaction="WebControlGruppa"
											name="action" value="delete">Удалить</button>
									</div>
								</div>
							</div>
						
						
						
						
						<c:out value="${row.name}" /></td>
						<td><c:out value="${row.note}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</form>
	</div>
	</div>
	
</body>
</html>