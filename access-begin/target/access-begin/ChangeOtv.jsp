<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@   taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/javascript.js"></script>
<meta charset="UTF-8">
<style >
<%@ include file='css/edit-form.css' %>
</style>
<title>Перенос матерериального средства</title>
</head>
<body>
<div class="form-style-10">
<h1>Материальные средства<span>Редактирование</span></h1>
	<form action="WebControlMaterial" method="post" >
<%-- 	<c:set var="action" scope="request" value="changeotvpost" /> --%>
	<c:set var="mats" value="${form.em}" scope="session"/>
	<c:set var="listOtv" value="${form.listOtv}" scope="session"/>
	<c:set var="listOtdel" value="${form.listOtdel}" scope="session" />
	<jsp:useBean id="now" class="java.util.Date" />
<%-- 	<c:set var="currendate" value="${now}"> </c:set> --%>
	<c:set var = "now1" value = "<%= new java.util.Date()%>" />
	<fmt:formatDate var="currentdate" value="${now1}" pattern="yyyy-MM-dd" />
	<div class="section"><span>&#9998</span>Поля материальных средств</div>
 <div class="inner-wrap">
	<table>
			<tr>
				<c:forEach items="${mats}" var="matRow">
					<tr> 
					   <td><label>название</label></label></td>
					   <td class="field"> <c:out value="${matRow.name}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>инвентарный номер</label></td>
					   <td class="field"> <c:out value="${matRow.invnumber}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>срийный номер</label></td>
					   <td class="field"> <c:out value="${matRow.sernumber}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>дата последнего перемещения</label></td>
					   <td class="field"> <c:out value="${matRow.dvigDateBegin}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>ответсвенный</label></td>
					   <td class="field"> <c:out value="${matRow.otvname}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>отдел</label></td>
					   <td class="field"> <c:out value="${matRow.otdname}"></c:out></td>
					</tr>
					<tr> 
					   <td><label>причина</label></td>
					   <td class="field"> <c:out value="${matRow.prichinastr}"></c:out></td>
					</tr><tr> 
					   <td><br><br></td>
					</tr>
				</c:forEach>
			</tr>
			 <tr><td><label>Дата перевода</label></td><td>
			 <input type="date" id="start" name="dvigdate"  value="${currentdate}" min="2000-01-01" max="2030-12-31"/>
			 </td></tr>
		
			
			</table>
			</div>


			<div class="section">
				<span>&#9998</span>Ответственные
			</div>
			<div class="inner-wrap">
				<table>
					<tr>
						<th></th>
						<th>ФИО</th>
						<th>должность</th>
					</tr>
					<tr>
						<td></td>
						<td><input type="text" size="40" id="complete-field"
							onkeyup="doCompletion();"></td>
						<td><input type="text" size="40" id="complete-field"
							onkeyup="doCompletion();"></td>
					</tr>
				</table>
				<div style="height: 400px; overflow-y: scroll;">
					<table>
						<c:forEach items="${listOtv}" var="otv">
							<tr>
								<td><input type="radio" name="otv" id="label-${otv.otvId}"
									value="${otv.otvId}"></td>
								<td><c:out
										value="${otv.surname} ${otv.name} ${otv.patronymic}"></c:out></td>
								<td><c:out value="${otv.postName}" /> <c:out
										value="${year}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div class="section">
				<span>&#9998</span>Учет материальных средств
			</div>
			<div class="inner-wrap">
				<div style="height: 400px; overflow-y: scroll;">
					<table>
						<tr>
							<th></th>
							<th>Отдел</th>
						</tr>
						<c:forEach items="${listOtdel}" var="otd">
							<tr>
								<td><input type="radio" name="otdel"
									id="label-${otd.otdelId}" value="${otd.otdelId}"></td>
								<td><c:out value="${otd.name}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<div class="button-section"><input type="submit" name="action" value="changeotvpost"></div>
			
		
	</form>
	</div>
</body>
</html>