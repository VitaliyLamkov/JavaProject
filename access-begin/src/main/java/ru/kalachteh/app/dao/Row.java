package ru.kalachteh.app.dao;
import java.util.HashMap;

public class Row {
	
	private HashMap<String, String> fields = new HashMap<String, String>();
	
public Row() {
	
}
public void setField(String key, String value) {
	fields.put(key, value);
}

public String getField(String key){
	return fields.get(key);
}

}
