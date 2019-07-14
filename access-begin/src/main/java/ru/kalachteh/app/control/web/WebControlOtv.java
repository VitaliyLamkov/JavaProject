package ru.kalachteh.app.control.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;

import ru.kalachteh.app.control.FormControlEditGrupa;
import ru.kalachteh.app.control.FormControlOtv;
import ru.kalachteh.app.dao.AbstractDaoControlFactory;
import ru.kalachteh.app.dao.ControlOtv;
import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.EntityOtv;
import ru.kalachteh.app.dao.ORDER;
import ru.kalachteh.app.dao.OTDELFIELD;
import ru.kalachteh.app.dao.OTVFIELD;

/**
 * Servlet implementation class WebControlOtv
 */
public class WebControlOtv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  final Logger log = Logger.getLogger(this.getClass());
    private static ControlOtv co = AbstractDaoControlFactory.getInstance().getControlOtv();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebControlOtv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getParameter("action");
		
		if (action == null || (action!=null && action.contentEquals("view")== true) ) {
			doView(request, response);
		}
		
		if (action != null && action.contentEquals("edit")== true ) {
			doEdit(request, response);
		
		}
		
		if (action != null && action.contentEquals("editpost")== true ) {
			doEditPost(request, response);
		
		}
		if (action != null && action.contentEquals("insert")== true ) {
			doInsert(request, response);
		
		}
		if (action != null && action.contentEquals("insertpost")== true ) {
			doInsertPost(request, response);
		
		}
		if (action != null && action.contentEquals("delete")== true ) {
			doDelPost(request, response);
		
		}
		 
	}
	
	protected void doView(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		if (order != null && sort != null)
			{
				co.orderBy(OTVFIELD.valueOf(sort.toUpperCase()), ORDER.valueOf(order.toUpperCase()));
			 
			}
		
		Collection<EntityOtv> otv = co.getResult();
		
		FormControlOtv form = new FormControlOtv();
		form.setEntityOtv(otv);
		request.setAttribute("form", form);
		
		getServletContext().getRequestDispatcher("/ViewOtv.jsp").forward(request, response);
		
	}
	protected void doEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		int intRow = Integer.parseInt(request.getParameter("row"));
		FormControlEditOtv form = new FormControlEditOtv();
		form.setOvetst(co.getById(intRow));
		
		form.setOtdel((ArrayList<EntityOtdel>)AbstractDaoControlFactory.getInstance().getControlOtdel().getResult());
		form.setPost((ArrayList<EntityPost>)AbstractDaoControlFactory.getInstance().getControlPost().getResult());
		
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditOtv.jsp").forward(request, response);
	}
	protected void doEditPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Map<String, String[]> params = (Map<String, String[]>)request.getParameterMap();
		co.update(params);
		co.refresh();
		doView(request, response);
	}
	protected void doInsert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
request.setCharacterEncoding("utf-8");
		

		FormControlEditOtv form = new FormControlEditOtv();
		
		form.setAction("insertpost");
		form.setOtdel((ArrayList<EntityOtdel>)AbstractDaoControlFactory.getInstance().getControlOtdel().getResult());
		form.setPost((ArrayList<EntityPost>)AbstractDaoControlFactory.getInstance().getControlPost().getResult());
		
		
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditOtv.jsp").forward(request, response);
	}
	protected void doInsertPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Map<String, String[]> params = (Map<String, String[]>)request.getParameterMap();
		co.insert(params);
		co.refresh();
		doView(request, response);
	}

protected void doDelPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String[] checkrows = req.getParameterValues("checkrow");

		co.delete(checkrows);
		co.refresh();
		doView(req, res);
	}

}
