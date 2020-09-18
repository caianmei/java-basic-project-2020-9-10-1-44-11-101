package com.thoughtworks.basic;

public class SchemaL implements Schema {

	private String key;
	private String value;
	
	public SchemaL() {
		this.key = CodeValueContant.SCHEMA_L;
	}
	
	public boolean judgeValueType() {
		return Boolean.valueOf(this.value);	
	}
	
	public void setDefault() {
		this.value = CodeValueContant.L_DEFAULT_VALUE;
	}

	@Override
	public String getDefault() {
		return CodeValueContant.L_DEFAULT_VALUE;
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
