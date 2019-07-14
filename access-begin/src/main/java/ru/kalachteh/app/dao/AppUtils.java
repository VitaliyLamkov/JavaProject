package ru.kalachteh.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class AppUtils {
	private static final Logger log = Logger.getLogger(AppUtils.class);
	
	public static boolean isDateNull(ResultSet set, String col) {
		try {
			java.sql.Date date = set.getDate(col);
			return set.wasNull();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}catch (NullPointerException e){
			e.printStackTrace();
			log.error(e);
		}
		return true;
		
	}

}
