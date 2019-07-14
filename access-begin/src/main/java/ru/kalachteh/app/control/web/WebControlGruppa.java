package ru.kalachteh.app.control.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import ru.kalachteh.app.control.FormControlEditGrupa;
import ru.kalachteh.app.control.FormControlGruppa;
import ru.kalachteh.app.dao.AbstractDaoControlFactory;
import ru.kalachteh.app.dao.ControlEntityLink;
import ru.kalachteh.app.dao.ControlGruppa;
import ru.kalachteh.app.dao.ControlMaterial;
import ru.kalachteh.app.dao.MATERILFIELD;
import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.GRUPPAFIELD;
import ru.kalachteh.app.dao.ORDER;

/**
 * Servlet implementation class WebControlGruppa
 */
public class WebControlGruppa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static ControlGruppa cg = AbstractDaoControlFactory.getInstance().getControlGruppa();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebControlGruppa() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	 String contextPath = getServletContext().getRealPath("/");
 		
 		FileAppender fa = new FileAppender();
 		fa.setName("FileLogger");
 		fa.setFile( contextPath+"1log.txt");
 		fa.setLayout(new PatternLayout("%d %5p [%c{1}] line:%L method:%M message:%m %n") );

 		fa.setThreshold(Level.ALL);
 		fa.setAppend(true);
 		fa.activateOptions();
 		Logger.getRootLogger().addAppender(fa);
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
//		AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb");
//		AbstractDaoControlFactory.setNAME("admin");
//		AbstractDaoControlFactory.setPASSWORD("postman");
//		ControlGruppa cg = AbstractDaoControlFactory.getInstance().getControlGruppa();
		
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		if (order != null && sort != null)
			{
			cg.orderBy(GRUPPAFIELD.valueOf(sort.toUpperCase()), ORDER.valueOf(order.toUpperCase()));
			 
			}
		
		Collection<EntityGruppa> eg = cg.getResult();
		
		
		FormControlGruppa form = new FormControlGruppa();
		form.setEntityGruppa(eg);
		request.setAttribute("form", form);
		
		Logger.getRootLogger().debug(form);
		
		getServletContext().getRequestDispatcher("/ViewGruppa.jsp").forward(request, response);
		
	}
	protected void doEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		int intRow = Integer.parseInt(request.getParameter("row"));
		FormControlEditGrupa form = new FormControlEditGrupa(cg.getById(intRow));
		log.debug("название группы:"+ cg.getById(intRow).getName().toString());
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditGruppa.jsp").forward(request, response);
		
	}
	protected void doEditPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Map<String, String[]> params = (Map<String, String[]>)request.getParameterMap();
		cg.update(params);
		cg.refresh();
		doView(request, response);
	}
	protected void doInsert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		FormControlEditGrupa form = new FormControlEditGrupa();
		form.setAction("insertpost");
		
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditGruppa.jsp").forward(request, response);
	}
	protected void doInsertPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		Map<String, String[]> params = (Map<String, String[]>)request.getParameterMap();
		cg.insert(params);
		cg.refresh();
		doView(request, response);
		
	}
	protected void doDelPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String[] checkrows = req.getParameterValues("checkrow");
//		log.debug("checkrows" + Arrays.toString(checkrows));
		cg.delete(checkrows);
		cg.refresh();
		doView(req, res);
	}


}
