package ru.kalachteh.app.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import ru.kalachteh.app.control.web.MainServlet;

public class ControlMaterial extends AbstractDaoControl<EntityMaterial, MATERILFIELD> {
	List <EntityMaterial> entityMaterial = new ArrayList<EntityMaterial>();

	private final Logger log = Logger.getLogger(this.getClass());

	public ControlMaterial(Connection connection) {
		super(connection);

		SQL = "SELECT * from ViewFullMaterial ";
		sqlFilter = new StringBuilder("");
		orderField=MATERILFIELD.NAME;
		
		filter = new HashMap<MATERILFIELD, String>(){{
			put(MATERILFIELD.MATERIAL_ID, null);
			put(MATERILFIELD.NAME, null); 
			put(MATERILFIELD.INVNUMBER, null);
			put(MATERILFIELD.MATDATEBEGIN , null);
			put(MATERILFIELD.SERNUMBER, null); 
			put(MATERILFIELD.NOTE , null);
			put(MATERILFIELD.SUMMA , null);
			put(MATERILFIELD.GRUPPA_ID , null);
			put(MATERILFIELD.SPISAN_FLAG , null);
			put(MATERILFIELD.GRNAME , null);
			put(MATERILFIELD.DVIGDATEBEGIN , null);
			put(MATERILFIELD.DVIGDATEEND , null);
			put(MATERILFIELD.OTVNAME , null);
			put(MATERILFIELD.PRICHINASTR , null);
			put(MATERILFIELD.OTDNAME , null);
		}};
		
		setKeyField("MATERIAL_ID");
		
		try {
			Statement statement = connection.createStatement();
//			System.out.println("*****ControlMaterial" + connection.isValid(0));
//			System.out.println(connection.getClientInfo().toString());

			ResultSet rs = statement.executeQuery(SQL);

			log.debug(SQL);
			while (rs.next()) {
				EntityMaterial em = new EntityMaterial(rs);
				
				
//				System.out.println(rs.getString("otvname"));
//				
//				System.err.println(rs.getString("otvname"));
		         
				entityMaterial.add(em);

			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<EntityMaterial> getResult() {
		
				return entityMaterial;
}
	@Override
	public List<EntityMaterial> refresh() {
		entityMaterial.clear();
		try {
					log.debug(SQL+getSqlFilter());
					Statement stSelect = connection.createStatement();
					ResultSet rs = stSelect.executeQuery(SQL+getSqlFilter());
					while(rs.next()) {
						EntityMaterial el =	new EntityMaterial(rs);
					entityMaterial.add(el);
					}
					stSelect.close();
					rs.close();
				}
				catch (SQLException ex) {
					ex.printStackTrace();
					log.error(ex);
				}
				
				orderBy(orderField, order);
		
				return entityMaterial;
	}

	@Override
	public EntityMaterial getById(int keyField) {
		// TODO Auto-generated method stub
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `ViewFullMaterial` WHERE `material_id`="+keyField);
			if (rs.next())
			   return new EntityMaterial(rs);
			else return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void orderBy(MATERILFIELD field, ORDER order) {
		// TODO Auto-generated method stub
//		super.orderBy();
		orderField=field;
		this.order=order;
		
		Comparator comparator = null;
		switch (field) {
		case NAME:
			comparator = new ComparatorMaterialName();
			break;
		case INVNUMBER:
			comparator = new ComparatorMaterialInvnumber();
			break;
		case MATDATEBEGIN:
			comparator = new ComparatorMaterialDatebegin();
			break;
		case DVIGDATEBEGIN:
			comparator = new ComparatorMaterialDvigDateBegin();
			break;
		case OTVNAME:
			comparator = new ComparatorMaterialOtvname();
			break;
		case OTDNAME:
			comparator = new ComparatorMaterialOtdel();
			break;
		case SERNUMBER:
			comparator = new ComparatorMaterialSernumber();
			break;
		case SPISAN_FLAG:
			break;
		}
		if (comparator != null && order==ORDER.ASC) {
			java.util.Collections.sort(entityMaterial, comparator);
		}

		if (comparator != null && order == ORDER.DESC) {
			java.util.Collections.sort(entityMaterial, java.util.Collections.reverseOrder(comparator));
		}

	}

	public void orderByTo() {
		// TODO Auto-generated method stub
//		super.orderBy();
		ComparatorMaterialName comporator = new ComparatorMaterialName();

		java.util.Collections.sort(entityMaterial, comporator);
	}

	@Override
	public void filterBy(ArrayList<String> filters, boolean add) {
		// TODO Auto-generated method stub
		super.filterBy(filters, add);
	}

	@Override
	public void insert(Map<String, String[]> listParams) {
		
		
		
try {
			
			PreparedStatement stInsert = connection.prepareStatement(
							"INSERT INTO `material`" + 
							"(`name`, `invnumber`, `date_begin`, `sernumber`, `note`, "
							+ "`summa`, `gruppa_id`, `spisan_flag`)" + 
							"VALUES(?,?,?,?,?,?,?,?)" );
			stInsert.setString(1, listParams.get("name")[0]);
			stInsert.setString(2, listParams.get("invnumber")[0]);
			stInsert.setDate(3, StringUtils.isBlank(listParams.get("matDateBegin")[0])==false ? java.sql.Date.valueOf(listParams.get("matDateBegin")[0]): null);
			stInsert.setString(4, listParams.get("sernumber")[0]);
			stInsert.setString(5, listParams.get("note")[0]);
			stInsert.setFloat(6, Float.valueOf(listParams.get("summa")[0]));
			stInsert.setInt(7, Integer.valueOf( listParams.get("gruppa_id")[0]));
			stInsert.setInt(8,listParams.get("spisan_flag") == null ? 0 : Integer.valueOf(listParams.get("spisan_flag")[0]));
			stInsert.setInt(8,CheckBox.OFF.getValue());
			
			stInsert.execute();

			stInsert.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void update(Map<String, String[]> listParams) {
		
		try {
			
			PreparedStatement stUpdate = connection.prepareStatement(
					"UPDATE `material` " + 
					"SET `name`=?, `invnumber`=?, `date_begin`=?, `sernumber`=?, "
					+ "`note`=?, `summa`=?, `gruppa_id`=?, `spisan_flag`=?" + 
					"WHERE `material_id`=?" );
			stUpdate.setString(1, listParams.get("name")[0]);
			stUpdate.setString(2, listParams.get("invnumber")[0]);
			stUpdate.setDate(3, StringUtils.isBlank(listParams.get("matDateBegin")[0])==false ? java.sql.Date.valueOf(listParams.get("matDateBegin")[0]): null);
			stUpdate.setString(4, listParams.get("sernumber")[0]);
			stUpdate.setString(5, listParams.get("note")[0]);
			stUpdate.setFloat(6, StringUtils.isBlank(listParams.get("summa")[0])== false ? Float.valueOf(listParams.get("summa")[0]) : null);
			stUpdate.setInt(7, Integer.valueOf( listParams.get("gruppa_id")[0]));
//			stUpdate.setInt(8,CheckBox.valueOf(listParams.get("spisan_flag")[0].toUpperCase()).getValue());
			stUpdate.setInt(8, listParams.get("spisan_flag") == null ? 0 : Integer.valueOf(listParams.get("spisan_flag")[0]));
			stUpdate.setInt(9, Integer.valueOf(listParams.get("material_id")[0]));
			stUpdate.execute();

			stUpdate.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void link(String row, String[] checkrows) {
		log.debug(row);
		log.debug(Arrays.toString(checkrows));
		
		if (!StringUtils.isBlank(row) && checkrows.length>0) {
			try {
				int icountOborud=0;
				int icountMater=0;
				int materialId = Integer.parseInt(row);
				PreparedStatement upLink = connection.prepareStatement("INSERT INTO `LinkOborud` " + 
						"( `material_id`, `oborud_id`)  VALUES( ?, ?)");
				
				PreparedStatement countObor = connection.prepareStatement("select count(*) AS countoborud "
						+ "from  `LinkOborud`  WHERE `oborud_id`= ? GROUP BY `oborud_id`");
				
				PreparedStatement countMat = connection.prepareStatement("select count(*) AS countmat "
						+ "from  `LinkOborud` WHERE `material_id`= ? GROUP BY `oborud_id`");
				
				for (String strcheckrow : checkrows) {
					int checkrow = Integer.parseInt(strcheckrow);
					countObor.setInt(1, checkrow);
					
					ResultSet rsCountObor = countObor.executeQuery();
					if (!rsCountObor.isBeforeFirst())
					while(rsCountObor.next()) {
						icountOborud=rsCountObor.getInt(1);
					}
					countMat.setInt(1, checkrow);
					ResultSet rsCountMat = countMat.executeQuery();
					if (!rsCountMat.isBeforeFirst())
					while(rsCountMat.next()) {
						icountMater=rsCountMat.getInt(1);
					}
					
					if (icountMater<1 && icountOborud<1) {
						upLink.setInt(1, materialId);
						upLink.setInt(2, checkrow);
						upLink.addBatch();
						log.debug("message");
					}
					upLink.executeBatch();
				}
				
			} catch(NumberFormatException e) {
				e.printStackTrace();
				log.error(e);
				
			} catch(SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
	}

	@Override
	public void delete(String[] listParams) {
		if (listParams!=null && listParams.length>0) {
			try {
				
				PreparedStatement stDelete = connection.prepareStatement("DELETE FROM `material` WHERE `material_id`=?");
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
	public void changeOtv(ArrayList<EntityMaterial> listMat, int otvId, int otdelId, String dvigDate) {
		
		
		for (EntityMaterial mat : listMat) {
			int lastDvig=0;
			try {
				PreparedStatement stGetLastDvig = connection.prepareStatement(
						"SELECT  top 1 `dvig_id`, `datebegin`FROM `dvig`"  + 
						"WHERE `material_id` = ? " + 
						"ORDER BY `datebegin` DESC" );
				stGetLastDvig.setInt(1, mat.getMaterial_id());
				ResultSet rsLastDvig = stGetLastDvig.executeQuery();
				while (rsLastDvig.next()) {
					lastDvig = rsLastDvig.getInt(1);
				}
				
				
				PreparedStatement stCloseDvig = connection.prepareStatement("UPDATE `dvig` " + 
						"SET  `dateend`=?  " + 
						"WHERE `dvig_id`=?" );
				stCloseDvig.setDate(1, java.sql.Date.valueOf(dvigDate));
				stCloseDvig.setInt(2, lastDvig);
				stCloseDvig.execute();
				
				PreparedStatement stNewDvig = connection.prepareStatement("INSERT INTO `dvig` " + 
						"(`prichina`, `otv_id`, `datebegin`, `dateend`, `typeprichina`, `material_id`, `otdel_id`) " + 
						"VALUES( ?, ?, ?, ?,?, ?, ?)" );
				
				stNewDvig.setString(1, "test");
				stNewDvig.setInt(2, otvId);
				stNewDvig.setDate(3, java.sql.Date.valueOf(dvigDate));
				stNewDvig.setDate(4, null); 
				stNewDvig.setInt(5, 1);		 
				stNewDvig.setInt(6, mat.getMaterial_id());	
				stNewDvig.setInt(7, otdelId);	
				stNewDvig.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public List<EntityMaterial> importMaterial(InputStream input){
//		log.debug(path);
		ArrayList<EntityMaterial> listEM = new ArrayList<EntityMaterial>();
		final String SPLITER = ",";
//		File file = new File(path);
//		FileReader fileReader = null;
//		FileReader fileReader = new FileReader(out);
		
		BufferedReader bufferedReader = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
//			fileReader = new FileReader(file);
//			bufferedReader = new BufferedReader(fileReader);
//			log.error("begin InputStreamReader");
			InputStreamReader r = new InputStreamReader(input);
			bufferedReader = new BufferedReader(r);
			String tmp = "";
			String words[] = null;
			while((tmp = bufferedReader.readLine())!=null) {
//				log.debug("tmp: "+tmp);
				words = tmp.split(",");
//				log.debug("words :"+Arrays.toString(words));
				EntityMaterial em = new EntityMaterial();
					em.setName(words[0]);
					em.setInvnumber(words[1]);
					em.setMatDateBegin(LocalDate.parse(words[2],formatter));
					listEM.add(em);
				
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			log.error(e);
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				}catch (IOException e) {
					e.printStackTrace();
					log.error(e);
				}
//				if (fileReader != null) {
//					try {
//						fileReader.close();
//					}catch (IOException e) {
//						e.printStackTrace();
//						log.error(e);
//					}
//				
//			}
		}
		}
		return listEM;
		
	}
	
	public void load(Map<String, String[]> listParams) {
		log.debug(Arrays.toString(listParams.keySet().toArray()));
			String [] dvigIdArray = listParams.get("dvigId");
	
			if (dvigIdArray != null && dvigIdArray.length>0) {
				try {
				
				PreparedStatement stLoad = connection.prepareStatement(
						"INSERT INTO `material`" + 
						"(`name`, `invnumber`, `date_begin`, `sernumber`, `note`, "
						+ "`summa`, `gruppa_id`, `spisan_flag`)" + 
						"VALUES(?,?,?,?,?,?,?,?)" );
				
				
					for (String strdvigId : dvigIdArray) {	
					
					stLoad.setString(1, listParams.get("name")[0]);
					stLoad.setString(2, listParams.get("invnumber")[0]);
					stLoad.setDate(3, StringUtils.isBlank(listParams.get("matDateBegin")[0])==false ? java.sql.Date.valueOf(listParams.get("matDateBegin")[0]): null);
					stLoad.setString(4, listParams.get("sernumber")[0]);
					stLoad.setString(5, listParams.get("note")[0]);
					stLoad.setFloat(6, Float.valueOf(listParams.get("summa")[0]));
					stLoad.setInt(7, Integer.valueOf( listParams.get("gruppa_id")[0]));
					stLoad.setInt(8,listParams.get("spisan_flag") == null ? 0 : Integer.valueOf(listParams.get("spisan_flag")[0]));
					
					stLoad.addBatch();
					}
				
				int[] count=stLoad.executeBatch();
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
		
}
	
//enum MaterialField {
//	NAME,
//	INVNUMBER,
//	DATE_BEGIN,
//	SERNUMBER,
//	NOTE,
//	SUMMA,
//	GRUPPA_ID,
//	SPISAN_FLAG
//}
