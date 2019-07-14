package ru.kalachteh.app.control.web;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;

import ru.kalachteh.app.control.FormControlMaterial;
import ru.kalachteh.app.dao.AbstractDaoControlFactory;
import ru.kalachteh.app.dao.ControlMaterial;
import ru.kalachteh.app.dao.EntityGruppa;
import ru.kalachteh.app.dao.EntityMaterial;
import ru.kalachteh.app.dao.MATERILFIELD;
import ru.kalachteh.app.dao.ORDER;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;

/**
 * Servlet implementation class WebControlImport
 */
public class WebControlImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());  
	private static List fileItems;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebControlImport() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		processRequejst(request, response);
	}
	
	protected void processRequejst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String action = getFields(request, response) != null ? getFields(request, response).get("action"):null;
		setMultipart(request, response);
		String action = getFields(request, response).get("action");
		
		log.debug("action: "+action);
		
		
		if (action == null || (action!=null && action.contentEquals("view")== true) ) {
			doView(request, response);
		}
		
		if (action != null && action.contentEquals("import")== true ) {
			doImport(request, response);
		}
		if (action != null && action.contentEquals("load")== true ) {
			doLoad(request, response);
		}
		if (action != null && (action.contentEquals("load")== false) &&  (action.contentEquals("load")== false)) {
			doView(request, response);
		}
			
	}
	protected void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		 
		 getServletContext().getRequestDispatcher("/Import.jsp").forward(request, response);
		
	}
	
	protected void doLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
    	//setMultipart(request, response);
    	
    	Map<String,String[]> params =  (Map<String, String[]>) request.getParameterMap();
    	
		getServletContext().getRequestDispatcher("/WebControlMaterial").forward(request, response);
		
	
	}
	protected void doImport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		 	boolean isMultipart;
//		    String filePath;
//		    int maxFileSize = 50 * 1024;
//		    int maxMemSize = 4 * 1024;
//		    File file ;
//	
//		    
		      isMultipart = ServletFileUpload.isMultipartContent(request);
//		      
//		   
		      if( isMultipart ) {
//		    	  log.info("22222222");
//		  
//		      DiskFileItemFactory factory = new DiskFileItemFactory();
//		      factory.setSizeThreshold(maxMemSize);
//		      factory.setRepository(new File(getServletContext().getRealPath("/")+"temp"));
//              ServletFileUpload upload = new ServletFileUpload(factory);
//		      upload.setSizeMax( maxFileSize );

		      try { 
		         
//		         List fileItems = upload.parseRequest(request);
			     Iterator i = fileItems.iterator();
			     while ( i.hasNext () ) {
			    	 log.info("333333");
		            FileItem fi = (FileItem)i.next();
		            if ( !fi.isFormField () ) {
		            	log.info("4");
		              ControlMaterial cm = AbstractDaoControlFactory.getInstance().getControlMaterial();
		              
		             List<EntityMaterial> list =  cm.importMaterial(fi.getInputStream());
		             
		             List<EntityGruppa> listgruppa = AbstractDaoControlFactory.getInstance().getControlGruppa().getResult();
		             request.setAttribute("em", list);
		             request.setAttribute("listgruppa", listgruppa);
//		              log.info("load stream");
//		              log.info(Arrays.toString(list.toArray()));
//		              log.info(fi.getOutputStream().toString());
            
		              
		            }
		         }
		        
		         } catch(Exception ex) {
		            System.out.println(ex);
		            log.error(ex);
		         }
		    
		
//				getServletContext().getRequestDispatcher("/WebControlMaterial").forward(request, response);
//				response.sendRedirect("WebControlImport");
				getServletContext().getRequestDispatcher("/Import.jsp").forward(request, response);
		      }
	}
	protected void setMultipart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 boolean isMultipart;
		   
		    int maxFileSize = 50 * 1024;
		    int maxMemSize = 4 * 1024;
		   
		    
		      isMultipart = ServletFileUpload.isMultipartContent(request);
		   
		      log.debug("getFields outer: " + isMultipart);
		   
		      if( isMultipart ) {
		    	  log.debug("getFields inner");
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      factory.setSizeThreshold(maxMemSize);
		      factory.setRepository(new File(getServletContext().getRealPath("/")+"temp"));
	     ServletFileUpload upload = new ServletFileUpload(factory);
		      upload.setSizeMax( maxFileSize );

		      try { 
		    	 
		         fileItems = upload.parseRequest(request);
		         log.debug(Arrays.toString(fileItems.toArray()));
		      } catch(Exception ex) {
		            System.out.println(ex);
		            log.error(ex);
		         }
		
	}
	}
	protected HashMap<String, String> getFields(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		   
	HashMap<String, String> map = new HashMap<String, String>(){{put("action", "view");}};
	if (fileItems != null) {
				Iterator i = fileItems.iterator();
		    
		     while ( i.hasNext () ) {
	            FileItem fi = (FileItem)i.next();
	            if ( fi.isFormField () ) {
	            			map.put(fi.getFieldName(), fi.getString());
//	            		log.debug(fi.getFieldName()+":"+fi.getString());
	            }
	      	    }
		     log.debug(map.toString());
	}
		     return map;
}
	      
}

