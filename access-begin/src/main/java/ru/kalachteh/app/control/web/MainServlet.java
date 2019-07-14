package ru.kalachteh.app.control.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;

import net.ucanaccess.jdbc.Context;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;




public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
       
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
//	ConsoleAppender consAppender = new ConsoleAppender(new SimpleLayout());	
//	FileAppender gileAppeender = new FileAppender(new SimpleLayout(), "logs.log.txt");
//	Logger.getRootLogger().addAppender(newAppender);
	 
	
		  
		  String contextPath = getServletContext().getRealPath("/");
		
		FileAppender fa = new FileAppender();
		fa.setName("FileLogger");
		fa.setFile( getServletContext().getRealPath("/")+"log.txt");
		
		fa.setLayout(new PatternLayout("дата%d %5p [%c{1}] %L %M %m %n") );

		fa.setThreshold(Level.ALL);
		fa.setAppend(false);
		fa.activateOptions();
		Logger.getRootLogger().addAppender(fa);
		
		 ConsoleAppender console = new ConsoleAppender(); //create appender
		  //configure the appender
//		  String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		  String PATTERN = "дата%d %5p [%c{1}] %L %M %m %n";
		  console.setLayout(new PatternLayout(PATTERN)); 
		  console.setThreshold(Level.ALL);
		  console.activateOptions();
		  //add appender to any Logger (here is root)
		  Logger.getRootLogger().addAppender(console);
		  
		  System.out.println("start logger");
		  Logger.getLogger(MainServlet.class).debug("start logger MainServlet");
		
		 
		
	}

}
