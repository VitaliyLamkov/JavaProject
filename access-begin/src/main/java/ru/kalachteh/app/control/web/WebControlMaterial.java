package ru.kalachteh.app.control.web;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import ru.kalachteh.app.dao.ControlMaterial;
import ru.kalachteh.app.dao.ControlOtdel;
import ru.kalachteh.app.dao.ControlOtv;
import ru.kalachteh.app.dao.EntityDvig;
import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.EntityLink;
import ru.kalachteh.app.dao.EntityMaterial;
import ru.kalachteh.app.dao.EntityOtdel;
import ru.kalachteh.app.dao.EntityOtv;
import ru.kalachteh.app.dao.LINKFIELD;
import ru.kalachteh.app.dao.MATERILFIELD;
import ru.kalachteh.app.dao.ORDER;
import ru.kalachteh.app.control.FormControlChangeotv;
import ru.kalachteh.app.control.FormControlEditMaterial;
import ru.kalachteh.app.control.FormControlMaterial;
import ru.kalachteh.app.control.FormControlMaterialCard;
import ru.kalachteh.app.dao.AbstractDaoControlFactory;
import ru.kalachteh.app.dao.ControlDvig;
import ru.kalachteh.app.dao.ControlEntityLink;
import ru.kalachteh.app.dao.ControlGruppa;

/**
 * Servlet implementation class WebControlMaterial
 */
public class WebControlMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static ControlMaterial viewMaterial = AbstractDaoControlFactory.getInstance().getControlMaterial();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequejst(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action = request.getParameter("post");
		processRequejst(request, response);
//		doChangeOtv(request, response);
		//getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected void processRequejst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		log.debug(action);
		
		if (action == null || (action!=null && action.contentEquals("view")== true) ) {
			doView(request, response);
		}
		
		if (action != null && action.contentEquals("changeotv")== true ) {
			doChangeOtv(request, response);
		}
		
		if (action != null && action.contentEquals("changeotvpost")== true ) {
			doChangeOtvPost(request, response);
		}
		
		if (action != null && action.contentEquals("edit")== true ) {
			doEditMaterial(request, response);
		}
		
		if (action != null && action.contentEquals("editpost")== true ) {
			doEditMaterialPost(request, response);
		}
		if (action != null && action.contentEquals("insert")== true ) {
			doInsertMaterial(request, response);
		}
		if (action != null && action.contentEquals("insertpost")== true ) {
			doInsertMaterialPost(request, response);
		}
		if (action != null && action.contentEquals("viewcard")== true ) {
			doViewCard(request, response);
		}
		if (action != null && action.contentEquals("delete")== true ) {
			doDel(request, response);
		}
		if (action != null && action.contentEquals("doeditdvigpost")== true ) {
			doEditDvigPost(request, response);
		}
		if (action != null && action.contentEquals("doinsertdvigpost")== true ) {
			doInsertDvigPost(request, response);
		}
		if (action != null && action.contentEquals("dodeldvigpost")== true ) {
			doDelDvigPost(request, response);
		}
		if (action != null && action.contentEquals("link")== true ) {
			doLink(request, response);
		}
		if (action != null && action.contentEquals("dellinkpost")== true ) {
			doDelLinkPost(request, response);
		}
		if (action != null && action.contentEquals("filterUp")== true ) {
			doFilter(request, response);
		}
		if (action != null && action.contentEquals("filterDown")== true ) {
			doFilterDown(request, response);
		}
		
	}
	

	protected void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	// TODO Auto-generated method stub
			//doGet(request, response);
			
//			response.setContentType("text/html");
//			response.setCharacterEncoding("utf-8");
//			PrintWriter writer = response.getWriter();
//			try {writer.println("<h1>begin1</h1>");
//			} finally {
//				writer.close();
//			}
			String sort = request.getParameter("sort");
			String order = request.getParameter("order");
			request.setCharacterEncoding("UTF-8");
//			AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/work/Basa.mdb");
//			AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb");
//			AbstractDaoControlFactory.setNAME("admin");
//			AbstractDaoControlFactory.setPASSWORD("postman");
			ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
//			System.out.println(sort);
//			 System.out.println(order);
//			
			if (order != null && sort != null)
				{
//				cm.orderBy(MATERIALFIELD.valueOf(sort.toUpperCase()), order);
				viewMaterial.orderBy(MATERILFIELD.valueOf(sort.toUpperCase()), ORDER.valueOf(order.toUpperCase()));
				 
				}
//			if (order != null && order.contentEquals("desc") == true)
//				cm.orderByTo();
//			List<EntityMaterial> material =  cm.getResult();
			viewMaterial.refresh();
			List<EntityMaterial> material =  viewMaterial.getResult();
			
			FormControlMaterial formMaterial = new FormControlMaterial();
			formMaterial.initForm(material);
			
//			String[] users = new String[] {"Tom", "Bob", "Sam"};
//			request.setAttribute("users", users);
////			String[] users = new String[] {"Tom", "Bob", "Sam"};
//			response.setContentType("text/html");
//			response.setCharacterEncoding("utf-8");
//			PrintWriter writer = response.getWriter();
//			try {
//				writer.println("<h1>go</h1>");
//				writer.println(sort);
//				writer.println(order);
	//
//			} finally {
//				writer.close();
//			}

			
			request.setAttribute("form", formMaterial);
			getServletContext().getRequestDispatcher("/ViewMaterial.jsp").forward(request, response);
		
	}
	
private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			String[] checkrows = request.getParameterValues("checkrow");
			viewMaterial.delete(checkrows);
			viewMaterial.refresh();
			doView(request, response);
	}

	protected void doFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	
//			String sort = request.getParameter("sort");
//			String order = request.getParameter("order");
			String name = request.getParameter("filtername");
			request.setCharacterEncoding("UTF-8");
//			ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
			
//			if (!StringUtils.isBlank(name))
//				{
////				cm.setFilter(MATERIALFIELD.NAME, " LIKE '"+name+"*' ");
//				viewMaterial.setFilter(MATERIALFIELD.NAME, " LIKE '"+name+"*' ");
//				 
//				}
			
			String field;
			if (!StringUtils.isBlank(request.getParameter("filtername")))
			{
				String str = request.getParameter("checkname")==null ? " LIKE '"+name+"*' ":"='"+name+"'";
				viewMaterial.setFilter(MATERILFIELD.NAME, str);
			}
			
			if (!StringUtils.isBlank(field=request.getParameter("filterotv")))
			{
				String str = request.getParameter("checkotv")==null ? " LIKE '"+field+"*' ":"='"+field+"'";
				viewMaterial.setFilter(MATERILFIELD.OTVNAME, str);
				log.debug(str);
			}
			if (!StringUtils.isBlank(field=request.getParameter("filterinventar")))
			{
				String str = request.getParameter("checkinv")==null ? " LIKE '"+field+"*' ":"='"+field+"'";
				viewMaterial.setFilter(MATERILFIELD.INVNUMBER, str);
			}
			if (!StringUtils.isBlank(field=request.getParameter("filterotd")))
			{
				String str = request.getParameter("filtercheckotd")==null ? " LIKE '"+field+"*' ":"='"+field+"'";
				viewMaterial.setFilter(MATERILFIELD.OTDNAME, str);
			}
			if (!StringUtils.isBlank(field=request.getParameter("filterdate")))
			{
				String str = request.getParameter("checkdate")==null ? " >"+field+"' ":"='"+field+"'";
				viewMaterial.setFilter(MATERILFIELD.DVIGDATEBEGIN, str);
			}
			if (!StringUtils.isBlank(field=request.getParameter("filtersumma")))
			{
				String str = request.getParameter("checksumma")==null ? " >'"+field+"' ":"='"+field+"'";
				viewMaterial.setFilter(MATERILFIELD.SUMMA, str);
			}
			
			
			List<EntityMaterial> material =  viewMaterial.refresh();
//			List<EntityMaterial> material =  cm.refresh();
			FormControlMaterial formMaterial = new FormControlMaterial();
			formMaterial.initForm(material);
			
			request.setAttribute("form", formMaterial);
			getServletContext().getRequestDispatcher("/ViewMaterial.jsp").forward(request, response);
		
	}
	protected void doFilterDown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String name = request.getParameter("name");
		request.setCharacterEncoding("UTF-8");
			viewMaterial.clearFilter();
				List<EntityMaterial> material =  viewMaterial.refresh();
		FormControlMaterial formMaterial = new FormControlMaterial();
		formMaterial.initForm(material);
		request.setAttribute("form", formMaterial);
		getServletContext().getRequestDispatcher("/ViewMaterial.jsp").forward(request, response);
	
}
	protected void doChangeOtv(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
//		String parametr = req.getParameter("material_id");
//		if (parametr == null) {
//			 doView(req, res);
//		}
//		else {
			
//			int materialId = Integer.valueOf(parametr);
//			AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb");
//			AbstractDaoControlFactory.setNAME("admin");
//			AbstractDaoControlFactory.setPASSWORD("postman");
			
			FormControlChangeotv form  = new FormControlChangeotv();
					
			ControlMaterial cMat = AbstractDaoControlFactory.getInstance().getControlMaterial();
			
			String[] checkrows = req.getParameterValues("checkrow");
			ArrayList<EntityMaterial> enMat = new ArrayList<EntityMaterial>();
			
			for (String row: checkrows) {
				int materialId = Integer.valueOf(row);
				enMat.add(cMat.getById(materialId));
				
				System.out.println("row" + row);
				
				}
			for (EntityMaterial mat : enMat ) {
				System.out.println(mat.getName());
			}
			
			
			form.setEm(enMat);
			
			ControlOtv cOtv = AbstractDaoControlFactory.getInstance().getControlOtv();
			
			form.setListOtv((ArrayList<EntityOtv>) cOtv.getResult());
			
			for (EntityOtv o : (ArrayList<EntityOtv>) cOtv.getResult()) {
				System.out.println(o.getName());
			}
			
			ControlOtdel cOtd = AbstractDaoControlFactory.getInstance().getControlOtdel();
			form.setListOtdel((ArrayList<EntityOtdel>)cOtd.getResult());
			
			req.setAttribute("form", form);
			getServletContext().getRequestDispatcher("/ChangeOtv.jsp").forward(req, res);
//		}
			
	}
	protected void doChangeOtvPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		ArrayList<EntityMaterial> listMat = (ArrayList<EntityMaterial>) req.getSession().getAttribute("mats");
	
		int otvId	= Integer.valueOf(req.getParameter("otv"))	;
		
		int otdelId = Integer.valueOf(req.getParameter("otdel"));
		String dvigDate= req.getParameter("dvigdate");
		ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
		cm.changeOtv(listMat, otvId, otdelId, dvigDate);
		

		doView(req, res);
		
}
	protected void doEditMaterial(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		int intRow = Integer.parseInt(req.getParameter("row"));
		
//		AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb");
//		AbstractDaoControlFactory.setNAME("admin");
//		AbstractDaoControlFactory.setPASSWORD("postman");
		ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
		ControlGruppa cg = AbstractDaoControlFactory.getInstance().getControlGruppa();
		
		FormControlEditMaterial form = new FormControlEditMaterial();
		
		form.setMat(cm.getById(intRow));
		form.setListGruppa((ArrayList<EntityGruppa>)cg.getResult());
		form.setAction("editpost");
		req.setAttribute("form", form);
		
		getServletContext().getRequestDispatcher("/EditMaterial.jsp").forward(req, res);
	}
	protected void doEditMaterialPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Map<String,String[]> params =  (Map<String, String[]>) req.getParameterMap();
		ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
		cm.update(params);
		doView(req, res);
	
	}
	protected void doInsertMaterial(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		FormControlEditMaterial form = new FormControlEditMaterial();
		form.setAction("insertpost");
		form.setMat(new EntityMaterial());
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		form.getMat().setMatDateBegin(LocalDate.now());
				
//		AbstractDaoControlFactory.setPATH("jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb");
//		AbstractDaoControlFactory.setNAME("admin");
//		AbstractDaoControlFactory.setPASSWORD("postman");
		ControlGruppa cg = AbstractDaoControlFactory.getInstance().getControlGruppa();
		form.setListGruppa((ArrayList<EntityGruppa>)cg.getResult());
		req.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/EditMaterial.jsp").forward(req, res);
		
		
		
	}
	protected void doInsertMaterialPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<String,String[]> params =  (Map<String, String[]>) req.getParameterMap();
		ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
		cm.insert(params);
		doView(req, res);
		
	}
	protected void doViewCard(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer materialId = 0;
		try {
			if (StringUtils.isBlank(req.getParameter("row"))) {
		       materialId = Integer.parseInt(req.getSession().getAttribute("row").toString());
			} else
			{
				materialId = Integer.parseInt(req.getParameter("row"));
				
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			log.error(e);
		}
		EntityMaterial em = AbstractDaoControlFactory.getInstance().getControlMaterial().getById(materialId);
			
			
			List<EntityDvig> ed = AbstractDaoControlFactory.getInstance().getControlDvig().getByMaterialId(materialId);
			
			
			List<EntityOtv> otv = AbstractDaoControlFactory.getInstance().getControlOtv().getResult();
			
			
			List<EntityOtdel> otd=AbstractDaoControlFactory.getInstance().getControlOtdel().getResult();
			
			ControlEntityLink cl=AbstractDaoControlFactory.getInstance().getControlLink();
			cl.setFilter(LINKFIELD.material_id, " ="+materialId.toString());
			List<EntityLink> link=cl.getResult();
			
			FormControlMaterialCard form = new FormControlMaterialCard();
			form.setEntityMaterial(em);
			form.setListEntityDvig(ed);
			form.setListOtv(otv);
			form.setListOtdel(otd);
			form.setListLink(link);
			
			req.setAttribute("form",form);
			getServletContext().getRequestDispatcher("/MaterialCard.jsp").forward(req, res);
			
	}
	protected void doEditDvigPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String[]> params =  (Map<String, String[]>) req.getParameterMap();
		ControlDvig cd = AbstractDaoControlFactory.getInstance().getControlDvig();
		cd.update(params);
//		log.info(params.get("materialId")[0]);
//	req.setAttribute("row", params.get("materialId")[0]);
//		doViewCard(req, res);
		doView(req, res);
		
	}
protected void doInsertDvigPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String[]> params =  (Map<String, String[]>) req.getParameterMap();
		ControlDvig cd = AbstractDaoControlFactory.getInstance().getControlDvig();
		cd.insert(params);
		log.info(params.get("materialId")[0]);
//	req.setAttribute("row", params.get("materialId")[0]);
//		doViewCard(req, res);
		doView(req, res);
		
	}
protected void doDelDvigPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	String[] checkrows = req.getParameterValues("rows");
	
	ControlDvig cd = AbstractDaoControlFactory.getInstance().getControlDvig();
	cd.delete(checkrows);
//	log.info(Arrays.toString(checkrows));
//req.setAttribute("row", params.get("materialId")[0]);
	doViewCard(req, res);
//	doView(req, res);
	
}

protected void doLink(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String row = req.getParameter("row");
	String rows[]=req.getParameterValues("checkrow");
	ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
	cm.link(row, rows);
	doView(req, res);
}
protected void doDelLinkPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	String[] checkrows = req.getParameterValues("linkrows");
	
	ControlEntityLink cl = AbstractDaoControlFactory.getInstance().getControlLink();
	cl.delete(checkrows);
//	log.info(Arrays.toString(checkrows));
//req.setAttribute("row", params.get("materialId")[0]);
	doViewCard(req, res);
//	doView(req, res);
	
}

















}
	