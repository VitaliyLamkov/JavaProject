<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style >
<%@ include file='css/Table-col.css' %>
<%-- <%@ include file='css/RadioCheckBox.css' %> --%>
</style>



 <div class="section"><span>&#9998</span>Учет материальных средств</div>
    <div class="inner-wrap">
<form action="">
    &#10004 строгое соответсвие<table>
  <colgroup>
      <col style="background:#C7DAF0;">
  </colgroup>
			<tr>
				<td><input name="checkname" type="checkbox"></td>
				<td>название</td>
				<td><input name="filtername"></td>
				<td><input name="checkotv" type="checkbox"></td>
				<td >отвественный</td>
				<td ><input name="filterotv"></td>


			</tr >
			<tr>
				<td><input name="checkinv" type="checkbox"></td>
				<td>инвентарный номер</td>
				<td><input name="filterinventar"></td>
				<td><input name="checkotd" type="checkbox"></td>
				<td>отдел</td>
				<td><input name="filterotd"></td>

			</tr>
			<tr>
				<td><input name="checkdate" type="checkbox"></td>
				<td>дата последнего перемещения</td>
				<td>с<input type="date" name="filterdate">по<input type="date" name="filterdate"></td>
				<td><input name="checksumma" type="checkbox"></td>
				<td>сумма</td>
				<td><input name="filtersumma"></td>

			</tr>



		</table>
               
    

    <div class="button-section">
<!--     <input type="hidden" name="action" value="filtermaterial"> -->
<!--      <input type="submit" name="сохранить измениения" style="width: 166px; "> -->
				<div class="panel-button">
						<button type="submit" formaction="WebControlMaterial" name="action" value="filterUp" >Установить</button>
						<button type="submit" formaction="WebControlMaterial" name="action" value="filterDown" >Сбросить</button>
						
					</div>

    </div>
    </div>
</form>

