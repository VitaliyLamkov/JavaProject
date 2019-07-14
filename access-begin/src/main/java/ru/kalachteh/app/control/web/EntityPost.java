package ru.kalachteh.app.control.web;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class EntityPost {
	private final Logger log = Logger.getLogger(this.getClass());
	int postId;
	String name;
	
//	post_id
//	name
	
	public EntityPost() {
		// TODO Auto-generated constructor stub
	}
	
	public EntityPost(ResultSet rs) {
		try {
			setPostId(rs.getInt("post_id"));
			setName(rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}
		
		
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
