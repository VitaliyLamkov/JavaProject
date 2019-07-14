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
<title>Insert title here</title>
</head>
<body>
<c:set var="mat" value="${form.mat}" />
<c:set var="listgruppa" value="${form.listGruppa}"/>
<c:set var="action" value="${form.action}" />

<div class="form-style-10">
<h1>Материальные средства<span>Редактирование</span></h1>
<form>
<input type="hidden" name="material_id" value="${mat.material_id}">
    <div class="section"><span>&#9998</span>Учет материальных средств</div>
    <div class="inner-wrap">
        <label>название<input type="text" name="name"  value="${mat.name}" /></label>
        <label>инвентарный номер<input type="text" name="invnumber" value="${mat.invnumber}"/></label>
        <label>серийный номер<input type="text" name="sernumber" value="${mat.sernumber}"/></label>
<%--          --%>
		<fmt:setLocale value="ru-RU"/>
		<fmt:parseDate var="datebegin" value="${mat.matDateBegin}" pattern="yyyy-MM-dd"> </fmt:parseDate>
		<fmt:formatDate var="datebegin" value="${datebegin}" pattern="yyyy-MM-dd" />
        <label>дата ввода<input type="date" name="matDateBegin" 
        
        value="${datebegin}" /></label>
        <label>примечание<input type="text" name="note" value="${mat.note}"/></label>
        <label>сумма<input type="number"  name="summa" value="${mat.summa}"/></label>
        <label>группа<select name="gruppa_id" size="12">
        <c:forEach items="${listgruppa}" var="gruppa">
							<c:if test="${gruppa.gruppaId eq mat.gruppa_id}">
								<option value="${gruppa.gruppaId}" selected="selected"><c:out
										value="${gruppa.name} "></c:out></option>
							</c:if>
							<c:if test="${gruppa.gruppaId ne mat.gruppa_id}">
								<option value="${gruppa.gruppaId}"><c:out
										value="${gruppa.name}"></c:out></option>
							</c:if>
	 </c:forEach>
         </select>
        
    </div>
    
    <div class="section"><span>&#9850</span>Списание</div>
    <div class="inner-wrap">
    	<c:if test="${mat.spisan_flag eq 1 }">
        <label>Списан<input type="checkbox" name="spisan_flag" value=1 checked="checked"/></label>
         </c:if>
         
         <c:if test="${mat.spisan_flag eq 0 }">
        <label>Списан<input type="checkbox" name="spisan_flag" value=1 ></label>
         </c:if>
         
         <c:if test="${empty mat.spisan_flag}">
        <label>Списан<input type="checkbox" name="spisan_flag" value=1 ></label>
         </c:if>
               
    </div>
    

    <div class="button-section">
    <input type="hidden" name="action" value="${action}"/>
     <input type="submit"  name="сохранить измениения" />
<!--      <span class="privacy-policy"> -->
<!--      <input type="checkbox" name="field7">You agree to our Terms and Policy.  -->
<!--      </span> -->
    </div>
</form>
</div>


</body>
</html>