package com.thoughtworks.basic;

public class SchemaD implements Schema {

	private String key;
	private String value;
	
	public SchemaD() {
		this.key = CodeValueContant.SCHEMA_D;
	}
	
	public boolean judgeValueType() {
		return true;	
	}
	
	public void setDefault() {
		this.value = CodeValueContant.D_DEFAULT_VALUE;
	}

	public String getDefault() {
		return CodeValueContant.D_DEFAULT_VALUE;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
