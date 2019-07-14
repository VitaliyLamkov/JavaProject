package ru.kalachteh.app.dao;

public enum CheckBox {
	OFF(0), ON(1);
	
	private int value;
	
	
	CheckBox(int value ){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
