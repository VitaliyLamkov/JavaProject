<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <style>
   <%@include file='css/slide-top-panel.css' %>
</style>
   
    
 <input class="open" id="top-box" type="checkbox" hidden>
       <label class="btn" for="top-box"></label>
        <div class="top-panel">
            <div class="message">

                    <c:out value="${requestScope.framefilter}" escapeXml="false" />

            </div>
        </div>



      