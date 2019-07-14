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
<title>Карточка учета материалов</title>
</head>
<body>
<c:set var="mat" value="${form.entityMaterial}"/>
<c:set var="ldvig" value="${form.listEntityDvig}"></c:set>
<c:set var="lotv" value="${form.listOtv }"/>
<c:set var="lotd"  value="${form.listOtdel}"/>
<c:set var="llink" value="${form.listLink}"/>
<c:set var="row" value="${mat.material_id}" scope="session"/>
<div class="form-style-10">
<h1>карточка учета<span><a href="WebControlMaterial?action=view&action=view&sort=name&order=asc">Материальные средства</a></span></h1>
 <div class="section"><span>&#9998</span>Основные поля</div>
 <div class="inner-wrap">
        <label>название<div class="field"><c:out value="${mat.name}" /></div></label>
        <label>инвентарный номер<div class="field"><c:out  value="${mat.invnumber}"/></div></label>
        <label>серийный номер<div class="field"><c:out  value="${mat.sernumber}"/></div></label>
		<fmt:setLocale value="ru-RU"/>
		<fmt:parseDate var="datebegin" value="${mat.matDateBegin}" pattern="yyyy-MM-dd"> </fmt:parseDate>
		<fmt:formatDate var="datebegin" value="${datebegin}" pattern="yyyy-MM-dd" />
        <label>дата ввода<div class="field"><c:out  value="${datebegin}" /></div></label>
        <label>примечани<div class="field"><c:out  value="${mat.note}"/></div></label>
        <label>сумма<div class="field"><c:out  value="${mat.summa}"/></div></label>
        <label>группа<div class="field"><c:out value="${mat.grname }" /></div></label>
<%--         <input type="hidden" name="row" value="${mat.material_id}"> --%>
</div>


<!-- движение материала -->
	

		<form>
			<div class="section">
				<span>&#9998</span>Движение материальных средств
			</div>
			<div class="inner-wrap">
			<table>
			<tr>
						<td><input type="date" name="dateBegin_new"
							value="${dvig.dateBegin}"></td>
						<td><input type="date" name="dateEnd_new"
							value="${dvig.dateEnd}"></td>
						<td><select name="otvId_new">
								<c:forEach items="${lotv}" var="otv">
									<option value="${otv.otvId}" selected="selected">
										<c:out value="${otv.surname} ${otv.name} ${otv.patronymic}"></c:out>
									</option>
								</c:forEach>
						</select></td>

						<td><select name="otdelId_new">
								<c:forEach items="${lotd}" var="otdel">
									<option value="${otdel.otdelId}" selected="selected"><c:out
											value="${otdel.name}"></c:out></option>
								</c:forEach>
						</select></td>

						<td><select name="prichinaId_new">
								<c:forEach items="${form.listPrichina}" var="pr">
									<option value="${pr.key}"><c:out value="${pr.value}"></c:out></option>
								</c:forEach>
						</select></td>
						
						<td><input type="hidden" name="materialId_new" value="${mat.material_id}"></td>
					</tr>
			</table>
			
			<div class="button-section">
					
					<button type="submit" formaction="WebControlMaterial" name="action"
						value="doinsertdvigpost">Новое движение</button>
				</div>
			
			<table>
					<c:forEach items="${ldvig}" var="dvig" >
				<tr>
				<td><input type="checkbox" name="rows" value="${dvig.dvigId}"></td>
				<td><input type="date" name="dateBegin_${dvig.dvigId}" value="${dvig.dateBegin}"></td>
				<td><input type="date" name="dateEnd_${dvig.dvigId}" value="${dvig.dateEnd}"></td>
				<td><select name="otvId_${dvig.dvigId}" >
        <c:forEach items="${lotv}" var="otv">
							<c:if test="${otv.otvId eq dvig.otvId}">
								<option value="${otv.otvId}" selected="selected">
								<c:out	value="${otv.surname} ${otv.name} ${otv.patronymic}" ></c:out>
								</option>
							</c:if>
							<c:if test="${otv.otvId ne dvig.otvId}">
								<option value="${otv.otvId}" >
								<c:out 	value="${otv.surname} ${otv.name} ${otv.patronymic}" ></c:out>
								</option>
							</c:if>
	 </c:forEach>
         </select>
				</td>
				
				<td>
				<select name="otdelId_${dvig.dvigId}" >
        <c:forEach items="${lotd}" var="otdel">
							<c:if test="${otdel.otdelId eq dvig.otdelId}">
								<option value="${otdel.otdelId}" selected="selected"><c:out
										value="${otdel.name}" ></c:out></option>
							</c:if>
							<c:if test="${otdel.otdelId ne dvig.otdelId}">
								<option value="${otdel.otdelId}"><c:out
										value="${otdel.name}" ></c:out></option>
							</c:if>
	 </c:forEach>
         </select>
         </td>
<%-- 				<td><input type="text" name="prichinaId_${dvig.dvigId}" value="${dvig.prichina}"></td> --%>
				
				<td><select name="prichinaId_${dvig.dvigId}" >
        <c:forEach items="${form.listPrichina}" var="pr">
							<c:if test="${pr.key eq dvig.typePrichina}">
								<option value="${pr.key}" selected="selected"><c:out
										value="${pr.value}" ></c:out></option>
							</c:if>
							<c:if test="${pr.key ne dvig.typePrichina}">
								<option value="${pr.key}"><c:out
										value="${pr.value}" ></c:out></option>
							</c:if>
	 </c:forEach>
         </select>
				</td>
				<td><input type="hidden" name="dvigId" value="${dvig.dvigId}"></td>
				<td><input type="hidden" name="materialId" value="${dvig.materialId}"></td>
<%-- 				<td><input type="hidden" name="otdelId" value="${dvig.otdelId}"></td> --%>
<%-- 				<td><input type="hidden" name="otvId" value="${dvig.otvId}"></td> --%>
				
				</tr>
			
			</c:forEach>
			</table>

				<div class="button-section">
					<button type="submit" formaction="WebControlMaterial" name="action"
						value="doeditdvigpost">Сохранить движение</button>
						<button type="submit" formaction="WebControlMaterial" name="action"
						value="dodeldvigpost">Удалить движение</button>
				</div>
				</div>
		</form>
	

		<!-- связи материала -->



		<form>
			<div class="section">
				<span>&#9998</span>Зависимоти материальных средств
			</div>
			<div class="inner-wrap">
				<table>
					<c:forEach items="${llink}" var="link">
						<tr>
							<td><input type="checkbox" name="linkrows"
								value="${link.linkOborudId}"></td>
							<td><input disabled="disabled" type="text" name="invnumber_${link.linkOborudId}"
								value="${link.invnumber}"></td>
							<td><input disabled="disabled" type="text"  name="name_${link.linkOborudId}"
								value="${link.name}"></td>
							<td><input disabled="disabled" type="text"  name="sernumber_${link.linkOborudId}"
								value="${link.sernumber}"></td>

						</tr>
					</c:forEach>
				</table>

				<div class="button-section">
<%-- 					<input type="hidden" name="action" value="${action}" /> --%>
					<button type="submit" formaction="WebControlMaterial" name="action"
						value="dellinkpost">Удалить</button>
				</div>
				</div>
		</form>
	


	</div>
	
	</body>
</html>