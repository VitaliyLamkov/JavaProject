<%@ page contentType="text/html; charset=utf-8" %>
<input type="checkbox" id="nav-toggle" hidden>
<style>
   <%@include file='css/left-nav-style.css' %>
</style>
<nav class="nav">
        <!-- 
    Метка с именем `id` чекбокса в `for` атрибуте
    Символ Unicode 'TRIGRAM FOR HEAVEN' (U+2630)
    Пустой атрибут `onclick` используем для исправления бага в iOS < 6.0
    См: http://timpietrusky.com/advanced-checkbox-hack 
    -->
        <label for="nav-toggle" class="nav-toggle" onclick></label>
        <!-- 
    Здесь размещаете любую разметку,
    если это меню, то скорее всего неупорядоченный список <ul>
    -->
        <h2 class="logo"> 
            <a href="//dbmast.ru/">Категории</a> 
        </h2>
        <ul>
            <li><a href="WebControlMaterial">Оборудованu</a>
            <li><a href="WebControlGruppa">Группы оборудования</a>
            <li><a href="WebControlOtv">Ответственные</a>
            <li><a href="WebControlOtdel">Отделы</a>
            <li><a href="ReportCardCount.jsp">Отчеты</a>
            <li><a href="WebControlImport">Импорт оборудования</a>
            <li><a href="MainServlet">Домой</a>
            
        </ul>
</nav>