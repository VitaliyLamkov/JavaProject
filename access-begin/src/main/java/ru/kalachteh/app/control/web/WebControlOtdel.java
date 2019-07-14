package ru.kalachteh.app.control.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ru.kalachteh.app.control.FormControlEditGrupa;
import ru.kalachteh.app.control.FormControlOtdel;
import ru.kalachteh.app.control.FormControlOtdelEdit;
import ru.kalachteh.app.dao.AbstractDaoControlFactory;
import ru.kalachteh.app.dao.ControlGruppa;
import ru.kalachteh.app.dao.ControlOtdel;
import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.GRUPPAFIELD;
import ru.kalachteh.app.dao.ORDER;
import ru.kalachteh.app.dao.OTDELFIELD;

/**
 * Servlet implementation class WebControlOtdel
 */
public class WebControlOtdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static 	ControlOtdel co = AbstractDaoControlFactory.getInstance().getControlOtdel();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebControlOtdel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getParameter("action");
		log.debug("Action :" + action);
		
		if (action == null || (action!=null && action.contentEquals("view")== true) ) {
			doView(request, response);
		}
		
		if (action != null && action.contentEquals("edit")== true ) {
			doEdit(request, response);
		
		}
		
		if (action != null && action.contentEquals("editpost")== true ) {
			doEditPost(request, response);
			log.debug("Action post!!!!!!!! :" + action);
		
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
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		if (order != null && sort != null)
			{
			co.orderBy(OTDELFIELD.valueOf(sort.toUpperCase()), ORDER.valueOf(order.toUpperCase()));
			 
			}
		
		Collection<EntityOtdel> eo = co.getResult();
		
//		for(EntityOtdel g : eo) {
//			System.out.println(g.getName());
//		}
//		
		
		FormControlOtdel form = new FormControlOtdel();
		form.setEntityOtdel(eo);
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/ViewOtdel.jsp").forward(request, response);
		
	}
	protected void doEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		int intRow = Integer.parseInt(request.getParameter("row"));
		FormControlOtdelEdit form = new FormControlOtdelEdit();
		form.setOtdel(co.getById(intRow));
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditOtdel.jsp").forward(request, response);
		
	}
	protected void doEditPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Map<String, String[]> params = (Map<String, String[]>)request.getParameterMap();
		co.update(params);
		co.refresh();
		doView(request, response);
	}
	protected void doInsert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
request.setCharacterEncoding("utf-8");
		
		FormControlOtdelEdit form = new FormControlOtdelEdit();
		form.setAction("insertpost");
		
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditOtdel.jsp").forward(request, response);
	
	}
	protected void doInsertPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		log.debug("!!!!!!!!!!!!insert post");
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
