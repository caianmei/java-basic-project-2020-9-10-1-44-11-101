package com.thoughtworks.basic;

import java.util.regex.Pattern;

public class SchemaP implements Schema {
	private String key;
	private String value;
	
	public SchemaP() {
		this.key = CodeValueContant.SCHEMA_P;
	}
	
	public boolean judgeValueType() {
		Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(this.value).matches() && Integer.valueOf(this.value) <= Integer.MAX_VALUE;	
	}
	
	public void setDefault() {
		this.value = CodeValueContant.P_DEFAULT_VALUE;
	}
	
	public String getDefault() {
		return CodeValueContant.P_DEFAULT_VALUE;
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
