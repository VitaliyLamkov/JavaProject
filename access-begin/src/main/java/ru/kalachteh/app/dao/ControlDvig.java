package ru.kalachteh.app.dao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import ru.kalachteh.app.control.web.MainServlet;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.Console;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;

public class ControlDvig extends AbstractDaoControl <EntityDvig, DVIGFIELD>{
	private  final Logger log = Logger.getLogger(this.getClass());
	
	
	List<EntityDvig> entityDvig = new ArrayList<EntityDvig>();
	
	public ControlDvig(Connection connection) {
		// TODO Auto-generated constructor stub
		super(connection);
		try {
			 Statement statement = connection.createStatement();
			 ResultSet rs = statement.executeQuery("select * from 'ViewDvig' order by 'datebegin'");
			 
			 while (rs.next()) {
				 EntityDvig ed = new EntityDvig(rs);
//				 	ed.setDvigId(rs.getInt("dvig_id"));
//				 	ed.setPrichina(rs.getString("prichina"));
//				 	ed.setTypePrichina(rs.getInt("typeprichina"));
//				 	ed.setOtvId(rs.getInt("otv_id"));
//				 	ed.setDateBegin(rs.getString("datebegin"));
//				 	ed.setDateEnd(rs.getString("dateend"));
//				 	ed.setMaterialId(rs.getInt("material_id"));
//				 	ed.setOtdelId(rs.getInt("otdel_id"));
//				 	ed.setOtdName(rs.getString("otdname"));
//				 	ed.setOtvName(rs.getString("otcname"));
//				 	ed.setPrichina(rs.getString("prichinastr"));
				 	 entityDvig.add(ed);
				 	
			 }
			 statement.close();
			 rs.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<EntityDvig> getResult() {
		// TODO Auto-generated method stub
		return entityDvig;
	}

	@Override
	public EntityDvig getById(int keyField) {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from 'ViewDvig' where  'dvig_id'=" + keyField);
			
			if (rs.isFirst()) {
				EntityDvig ed = new EntityDvig(rs);
//				ed.setDvigId(rs.getInt("dvig_id"));
//			 	ed.setPrichina(rs.getString("prichina"));
//			 	ed.setTypePrichina(rs.getInt("typeprichina"));
//			 	ed.setOtvId(rs.getInt("otv_id"));
//			 	ed.setDateBegin(rs.getString("datebegin"));
//			 	ed.setDateEnd(rs.getString("dateend"));
//			 	ed.setMaterialId(rs.getInt("material_id"));
//			 	ed.setOtdelId(rs.getInt("otdel_id"));
//			 	ed.setOtdName(rs.getString("otdname"));
//			 	ed.setOtvName(rs.getString("otcname"));
//			 	ed.setPrichina(rs.getString("prichinastr"));
			 	 entityDvig.add(ed);
			 	 return ed;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}
		// TODO Auto-generated method stub
		return null;
	}
	public List<EntityDvig> getByMaterialId(int keyField) {
		try {
				PreparedStatement sel = connection.prepareStatement(
						"SELECT * "
						+ "FROM `ViewDvig` "
						+ "WHERE `material_id`=?");
				ArrayList<EntityDvig> list =  new ArrayList<EntityDvig>();
				sel.setInt(1, keyField);
				ResultSet rs = sel.executeQuery();
				while (rs.next()) {
					EntityDvig ed = new EntityDvig(rs);
					list.add(ed);
//					log.debug(rs.getString("otvname"));
				}
				sel.close();
				rs.close();
				return list;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}

	@Override
	public void orderBy(DVIGFIELD field, ORDER order) {
		// TODO Auto-generated method stub
		super.orderBy(field, order);
	}

	@Override
	public void filterBy(ArrayList<String> filters, boolean add) {
		// TODO Auto-generated method stub
		super.filterBy(filters, add);
	}

	@Override
	public void insert(Map<String, String[]> listParams) {
		
		
		log.debug(Arrays.deepToString(listParams.values().toArray()));
		log.debug(Arrays.toString(listParams.keySet().toArray()));
		if (StringUtils.isBlank(listParams.get("otvId_new")[0]) == false
		&& StringUtils.isBlank(listParams.get("otdelId_new")[0]) == false
		&& StringUtils.isBlank(listParams.get("prichinaId_new")[0]) == false
		&& StringUtils.isBlank(listParams.get("dateBegin_new")[0]) == false	) {
			
			log.debug(listParams.get("otvId_new")[0]);
			log.debug(listParams.get("otdelId_new")[0]);
			log.debug(listParams.get("prichinaId_new")[0]);
			log.debug(listParams.get("dateBegin_new")[0]);
			log.debug(listParams.get("materialId_new")[0]);
			log.debug(listParams.get("dateBegin_new")[0]);
			
			
			try {
				PreparedStatement stInsert = connection.prepareStatement("INSERT INTO `dvig` " + 
						"(`otv_id`, `datebegin`, `dateend`, `typeprichina`, `material_id`, `otdel_id`) " + 
						"VALUES( ?, ?, ?, ?, ?, ?)" );
				
				stInsert.setInt(1, Integer.parseInt(listParams.get("otvId_new")[0]));
				stInsert.setDate(2,StringUtils.isBlank(listParams.get("dateBegin_new")[0])==false ? java.sql.Date.valueOf(listParams.get("dateBegin_new")[0]):null);
				stInsert.setDate(3, StringUtils.isBlank(listParams.get("dateEnd_new")[0])==false ? java.sql.Date.valueOf(listParams.get("dateEnd_new")[0]):null);
				stInsert.setInt(4, Integer.parseInt(listParams.get("prichinaId_new")[0]));
				stInsert.setInt(5, Integer.parseInt(listParams.get("materialId_new")[0]));
				stInsert.setInt(6, Integer.parseInt(listParams.get("otdelId_new")[0]));
				
				stInsert.executeUpdate();
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				log.error(e);
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
			
		}
	}

	@Override
	public void update(Map<String, String[]> listParams) {
		log.debug(Arrays.toString(listParams.keySet().toArray()));
			String [] dvigIdArray = listParams.get("dvigId");
			if (dvigIdArray != null && dvigIdArray.length>0) {
				
				try {
					PreparedStatement stUpdate = connection.prepareStatement(
							"UPDATE `dvig` " + 
							"SET `prichina`=NULL, "
							+ "`otv_id`=?, "
							+ "`datebegin`=? , "
							+ "`dateend`=? , `"
							+ "typeprichina`=? , "
							+ "`material_id`=? , "
							+ "`otdel_id`=? " 
							+ "WHERE `dvig_id`=? ");
					
				for (String strdvigId : dvigIdArray) {
						 int dvigId = Integer.parseInt(strdvigId);
						 stUpdate.setInt(1, Integer.parseInt(listParams.get("otvId_"+dvigId)[0]));
						 stUpdate.setDate(2,StringUtils.isBlank(listParams.get("dateBegin_"+dvigId)[0])==false ? java.sql.Date.valueOf(listParams.get("dateBegin_"+dvigId)[0]):null);
						 stUpdate.setDate(3, StringUtils.isBlank(listParams.get("dateEnd_"+dvigId)[0])==false ? java.sql.Date.valueOf(listParams.get("dateEnd_"+dvigId)[0]):null);
						 stUpdate.setInt(4, Integer.parseInt(listParams.get("prichinaId_"+dvigId)[0]));
						 stUpdate.setInt(5, Integer.parseInt(listParams.get("materialId")[0]));
						 stUpdate.setInt(6, Integer.parseInt(listParams.get("otdelId_"+dvigId)[0]));
						 stUpdate.setInt(7, dvigId);
						 stUpdate.addBatch();
					}
				
				int[] count=stUpdate.executeBatch();
//				log.info("обработано" + Arrays.toString(count));
					} catch (NumberFormatException e) {
						e.printStackTrace();
						log.error(e);
					} catch (SQLException e) {
						e.printStackTrace();
						log.error(e);
					}
				
			
			} else {
				log.debug("dvigIdArray is null or empty!");
			}
			
		
	}

	@Override
	public void delete(String[] listParams) {
		
		if (listParams!=null && listParams.length>0) {
			try {
				
				PreparedStatement stDelete = connection.prepareStatement("DELETE FROM `dvig` WHERE `dvig_id`=?");
				for (String srow : listParams) {
				int row = Integer.parseInt(srow);
				stDelete.setInt(1, row);
				stDelete.addBatch();
				}
				stDelete.executeBatch();
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				log.error(e);
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			
		
			
		}
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
