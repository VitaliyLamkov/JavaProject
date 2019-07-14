<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
<%@ include file="css/report.css" %>
</style>
<title>Учетная карточка</title>
</head>
<body>
<%
Context ctx = new InitialContext();
pageContext.setAttribute("sourceDB", (DataSource) ctx.lookup("java:comp/env/jdbc/InventDB"));
%>
<sql:query var="otv"  dataSource="${sourceDB}">SELECT * FROM material;</sql:query>
<!-- начало репорта -->
<div class="report">
<!-- <h1>Clients report</h1> -->
<!-- Custom HTML header -->
<!-- <div id="header"> -->
<!--     <h2>Annual Report of our Company</h2> -->
<!-- </div>  Custom HTML footer -->
<!-- <div id="footer"> -->
<!--     <h2>Address: William Road</h2> -->
<!--     <span class="custom-footer-page-number">Number: </span> -->
<!-- </div> -->
<table  width="600" border="1">	
	<thead class="title">Заголовок отчета</thead>
	
	<th>название</th>
					<th>инв. номер</th>
					<th>дата учета</th>
					<th>ответственный</th>
					<th>отдел</th>
					<th>сумма ввода</th>
					
	
		<sql:query var="gruppa" dataSource="${sourceDB}"> 
SELECT `gruppa_id`, `grname` FROM `ViewFullMaterial`
	GROUP BY `gruppa_id`, `grname`
	ORDER BY `grname`
</sql:query>
<tbody class="1level">
		<c:forEach items="${gruppa.rows}" var="rowGruppa">
		<tr>
			<td>
				<c:out value="${rowGruppa.grName}" />
			</td>
		</tr>	
</tbody>
			<sql:query var="mat" dataSource="${sourceDB}">
   	SELECT * FROM `ViewFullMaterial` WHERE `gruppa_id`=?
		ORDER BY  `name`
		<sql:param value="${rowGruppa.gruppa_id}" />
			</sql:query>
			<tbody>
			<c:forEach items="${mat.rows}" var="rowMat">
				<tr class="row">
					<td class="1column"><c:out value="${rowMat.name}" /></td>
					<td class="cell" ><c:out value="${rowMat.invnumber}" /></td>
					<td class="cell" ><c:out value="${rowMat.datebegin}" /></td>
					<td class="cell"><c:out value="${rowMat.otvname}" /></td>
					<td class="cell" ><c:out value="${rowMat.otdname}" /></td>
					<td class="cell"><c:out value="${rowMat.summa}" /></td>
				</tr>
			</c:forEach>
			</tbody>
			<tbody class="2level">
			<tr> <td colspan="6">
			<div class="2level">количество<c:out value="${rowMat.rowCount}"></c:out></div>
			</td>
			</tr>
			</tbody>
		</c:forEach>
	
<!-- 	конец репорта -->
</div>
</table>
</body>	
</html>

















