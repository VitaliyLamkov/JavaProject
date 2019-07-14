package ru.kalachteh.app.control.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.kalachteh.app.dao.MainConnection;
import ru.kalachteh.app.dao.Query;
import ru.kalachteh.app.dao.Row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class MainServlet
 * jdbc:ucanaccess:///home/hpusr/Общедоступные/VirtualBox/admin/Basa.mdb
 */
public class MainServletOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServletOld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>begin1</h1>");
		String databaseUrl = "jdbc:ucanaccess:///home/hpusr/work/Basa.mdb";
//		try {
//			 
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        }
//        catch(ClassNotFoundException e) {
// 
//         writer.println(e.toString());
//        }
		//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		final String USERNAME = "admin";
		final String PASSWORD = "postman";
		
		MainConnection con = new MainConnection(databaseUrl,USERNAME , PASSWORD);
		Connection connection;
		try {
			//connection = con.getConnection();
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("Select * from Personnel");
////			
//			while (result.next()) {
//				String surname = result.getString("Surname");
//				String name = result.getString("Name");
//				String patronymic = result.getString("Patronymic");
//				writer.println(surname +" | "+name + " | "+ patronymic);
//				writer.println("<br>");
//			}
//			
//			writer.println("end!!!!!");
			Query qrPersonnel = new Query();
			
			
			
			qrPersonnel.setConnection(con);
			qrPersonnel.setTable("Personnel");
			qrPersonnel.setFields(new ArrayList<String>(){{
				add("Personnel_id");
				add("Surname");
				add("Name");
				add("Patronymic");
	     	}});
			qrPersonnel.setPk("Personnel_id");
			
				qrPersonnel.getAll();
			
			writer.println("sql4");
			
			ArrayList<Row> table = qrPersonnel.tableArray;
			writer.println(table.toArray().toString());
			for (Row row : table) {
				
				String surname = row.getField("Personnel_id")+"****" + row.getField("Surname");
				String name = row.getField("Name");
				String patronymic = row.getField("Patronymic");
				writer.println(surname +" | "+name + " | "+ patronymic);
				writer.println("<br>");
				
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(writer);
		}
		writer.println("con"  + con.toString());
		
		writer.println("sql");
		
//		Query qrPersonnel = new Query();
//		writer.println(qrPersonnel.toString());
//		
//		qrPersonnel.setConnection(con);
//		qrPersonnel.setTable("Personnel");
//		qrPersonnel.setFields(new ArrayList<String>(){{
//			add("Surname");
//			add("Name");
//			add("Patronymic");
//     	}});
//		try {
//			qrPersonnel.getAll();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			writer.println("<h5>sql2<h5>");
//			e1.printStackTrace(writer);
//			writer.println("sql3");
//		}
////		
//		writer.println("sql4");
//		
//		ArrayList<Row> table = qrPersonnel.table;
//		
//		for (Row row : table) {
//			
//			String surname = row.getField("Surname");
//			String name = row.getField("Name");
//			String patronymic = row.getField("Patronymic");
//			writer.println(surname +" | "+name + " | "+ patronymic);
//			writer.println("<br>");
//			
//			
//		}
		
		
//		try(Connection connection = DriverManager.getConnection(databaseUrl,USERNAME , PASSWORD))
	//writer.println(con.getConnection().);
		
//		try		{
//			String sql = "SELECT * from Personnel";
//			Statement statement = con.getConnection().createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			
//			while (result.next()) {
//				String surname = result.getString("Surname");
//				String name = result.getString("Name");
//				String patronymic = result.getString("Patronymic");
//				writer.println(surname +" | "+name + " | "+ patronymic);
//				writer.println("<br>");
//			}
//			
//			writer.println("end!!!!!");
//			
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			writer.println(e.toString());
//		}
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
