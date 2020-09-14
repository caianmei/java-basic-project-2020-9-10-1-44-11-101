package com.thoughtworks.basic;

public class Schema {
	private  String[] schema= {"-l","-p","-d"};

	private boolean lVaule = false;
	private int pValue = 8080;
	private String dValue = "";

	public void setlVaule(boolean lVaule) {
		this.lVaule = lVaule;
	}

	public boolean getlValue() {
		return this.lVaule;
	}
	public int getpValue() {
		return pValue;
	}

	public void setpValue(int pValue) {
		this.pValue = pValue;
	}

	public String getdValue() {
		return dValue;
	}

	public void setdValue(String dValue) {
		this.dValue = dValue;
	}

	public String[] getSchema() {
		return schema;
	}

	public void setSchema(String[] schema) {
		this.schema = schema;
	}
	
	
}
