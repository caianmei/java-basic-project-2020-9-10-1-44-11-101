package com.thoughtworks.basic;

public class SchemaUnkown implements Schema{

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean judgeValueType() {
		return false;
	}

	@Override
	public void setDefault() {
		
	}

	@Override
	public String getDefault() {
		return null;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
