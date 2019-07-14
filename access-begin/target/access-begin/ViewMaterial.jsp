<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ page isELIgnored = "false" %> --%>
<%-- <jsp:useBean id="hello" class="beans.HelloBeans"></jsp:useBean> --%>
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
<c:import url="FrameFilterMaterial.jsp"  var="framefilter" scope="request"></c:import>
<c:import url="PanelFilter.jsp"/>
	<c:import url="nav.jsp" />

<%-- 	<c:out value="framefilter" /> --%>
<%-- 	<c:out value="123+${45+12}"></c:out> --%>
<%-- 	<c:out value="${users[1]}" default="NO nehrena!!"></c:out> --%>
	<br>
	<br>
	<div class="form-style-10">
<h1>Материальные средства<span>просмотр</span></h1>
 <div class="section"><span>&#9998</span>Учет материальных средств</div>
    <div class="inner-wrap">
	<form>
	<table>
		<tr>
			<th>название<br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=name&order=asc" class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=name&order=desc" class="button13">&#11015</a>
					</div>
				</div>
			</th>

			<th>инвентарный номер <br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=invnumber&order=asc" 
							class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=invnumber&order=desc"
							class="button13">&#11015</a>
					</div>
				</div>

			</th>
			<th>сер. номер<br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=sernumber&order=asc"
							class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=sernumber&order=desc"
							class="button13">&#11015</a>
					</div>
				</div>
			</th>


			</th>
			<th>дата последнего перемещения<br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=dvigDateBegin&order=asc"
							class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=dvigDateBegin&order=desc"
							class="button13">&#11015</a>
					</div>
				</div>
			</th>

			</th>
			<th>отвественный<br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=otvname&order=asc"
							class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=otvname&order=desc"
							class="button13">&#11015</a>
					</div>
				</div>
			</th>

			</th>
			<th>отдел<br>
				<div class="panel-button">
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&action=view&sort=otdname&order=asc"
							class="button13">&#11014</a>
					</div>
					<div class="panel-button">
						<a href="WebControlMaterial?action=view&sort=otdname&order=desc"
							class="button13">&#11015</a>
					</div>
				</div>
			</th>



			<th>сумма</th>
		</tr>
		<c:forEach items="${form.material}" var="mat" varStatus="status">
			<tr>
				<td>
				<input type="checkbox" id="hd-${status.index}" class="hide" />
					<label for="hd-${status.index}"><c:out value="${mat.name}" /></label>
					
					 						
					<div>
					<div>
					<input type="radio" name="row" id="label-${mat.material_id}"
								value="${mat.material_id}">

					<input type="checkbox" name="checkrow" value="${mat.material_id}">
					</div>
					<div>
						<c:out value="${mat.grname}" />
						<br>
						<c:out value="${mat.matDateBegin}" />
						
						<br>
						<c:out value="${mat.prichinastr}" />
					</div>
					
					<div>
					<div class="panel-button">
<%-- 						<a href="WebControlMaterial?action=changeotv&material_id=${mat.material_id}" --%>
<!-- 							class="button13">&#11014 Сменить владельца</a> -->

						<button type="submit" formaction="WebControlMaterial" name="action" value="changeotv">Сменить ответственного</button>
						    
					</div>
					
					<div class="panel-button">

						<button type="submit" formaction="WebControlMaterial" name="action" value="viewcard" >Карточка</button>
					</div>
					
					<div class="panel-button">

						<button type="submit" formaction="WebControlMaterial" name="action" value="link">Связать мат. средство</button>
					</div>
					
					<div class="panel-button">
						<button type="submit" formaction="WebControlMaterial" name="action" value="edit" >Редактировать</button>
					</div>
					
					<div class="panel-button">
						<button type="submit" formaction="WebControlMaterial" name="action" value="insert" >Добавить</button>
					</div>
					
					<div class="panel-button">
						<button type="submit" formaction="WebControlMaterial" name="action" value="delete" >Удалить</button>
					</div>
					
					</div>
					</div>
				</td>	
					
					
					
				<td><c:out value="${mat.invnumber}" /></td>
				<td><c:out value="${mat.sernumber}"></c:out></td>
				<td>
<%-- 				<fmt:formatDate pattern = "dd-MM-yyyy" value = "${mat.dvigDateBegin}" /> --%>
<%-- 		<c:if test="${not empty mat.dvigDateBegin}"> --%>
<%--          	<fmt:formatDate var="datebegin" value="${mat.dvigDateBegin}" pattern="yyyy-MM-dd" /> --%>
<%--          	<c:out value="${datebegin}" /> --%>
<%--         </c:if> --%>
         
         <c:out value="${mat.dvigDateBegin}" />
         </td>
				<td><c:out value="${mat.otvname}" /></td>
				<td><c:out value="${mat.otdname}"></c:out></td>
				<td><c:out value="${mat.summa}" /></td>
			</tr>
		</c:forEach>
	</table>
	</form>
	</div>
	</div>
</body>
</html>