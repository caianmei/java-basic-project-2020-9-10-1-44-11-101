package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

public class SchemaType {

	private List<String> schemaTypes = new ArrayList<String>();
	
	public List<String> getSchemaTypes() {
		return schemaTypes;
	}

	public SchemaType() {
		this.schemaTypes.add(CodeValueContant.SCHEMA_L);
		this.schemaTypes.add(CodeValueContant.SCHEMA_P);
		this.schemaTypes.add(CodeValueContant.SCHEMA_D);
	}
}
