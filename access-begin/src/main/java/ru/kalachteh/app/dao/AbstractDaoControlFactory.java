package ru.kalachteh.app.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ru.kalachteh.app.control.web.ControlPost;



public  class AbstractDaoControlFactory implements DaoControlFactory {
	protected static String PATH;
	protected static String NAME;
	protected static String PASSWORD;
	protected static Connection connection;
	protected static  AbstractDaoControlFactory instance;
    private static DataSource dataSource;
	
	public static synchronized AbstractDaoControlFactory getInstance() {
		if (instance == null) {
//			try {
//				instance = new AbstractDaoControlFactory();
//				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//				connection = DriverManager.getConnection(PATH, NAME , PASSWORD);
//				
//				
//				
//			} catch(ClassNotFoundException e) {
//				 
//		        e.printStackTrace();
//		        }
//			catch (SQLException e) {
//				e.printStackTrace();
//			}
			
			 
		            try {
		                instance =  new AbstractDaoControlFactory();
		                Context ctx = new InitialContext();
		                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/InventDB");
		                connection = dataSource.getConnection();
		            } catch (NamingException e) {
		                e.printStackTrace();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        
		}
		return instance;
	}

	@Override
	public void setConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return connection;
	}

	@Override
	public ControlMaterial getControlMaterial() {
		// TODO Auto-generated method stub
		return new ControlMaterial(connection);
	}
	
		
	@Override
	public ControlDvig getControlDvig() {
		// TODO Auto-generated method stub
		return new ControlDvig(connection);
	}

	@Override
	public ControlGruppa getControlGruppa() {
		// TODO Auto-generated method stub
		return new ControlGruppa(connection);
	}

	@Override
	public ControlOtv getControlOtv() {
		// TODO Auto-generated method stub
		return new ControlOtv(connection);
	}
	
	@Override
	public ControlOtdel getControlOtdel() {
		// TODO Auto-generated method stub
		return new ControlOtdel(connection);
	}
	
	@Override
	public ControlEntityLink getControlLink() {
		// TODO Auto-generated method stub
		return new ControlEntityLink(connection);
	}
	@Override
	public ControlPost getControlPost() {
		// TODO Auto-generated method stub
		return new ControlPost(connection);
	}

	public static String getPATH() {
		return PATH;
	}

	public static synchronized void setPATH(String path) {
		PATH = path;
	}

	public static String getNAME() {
		return NAME;
	}

	public static synchronized void setNAME(String name) {
		NAME = name;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static synchronized void setPASSWORD(String password) {
		PASSWORD = password;
	}

}
