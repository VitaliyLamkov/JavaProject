package ru.kalachteh.app.dao;
import java.sql.Connection;
import java.sql.SQLException;

import ru.kalachteh.app.control.web.ControlPost;

public interface DaoControlFactory {
	public void setConnection();
	public Connection getConnection();
	
	public ControlMaterial getControlMaterial();
	public ControlDvig getControlDvig();
	public ControlGruppa getControlGruppa();
	public ControlOtv getControlOtv(); 
	public ControlOtdel getControlOtdel();
	public ControlEntityLink getControlLink();
	public ControlPost getControlPost();
}
