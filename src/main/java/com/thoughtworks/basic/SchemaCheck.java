package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchemaCheck {
	
	private Args args = new Args();
	private Arg arg = new Arg();
	
	public List<Schema> schemaCheck(String inputParam) {		
		List<String> inputParams = splitInput(inputParam);
		List<Schema> schemas = args.args(inputParams);
		arg.arg(schemas);
		inintNotInputValue(schemas);
		return schemas;		
	}
	
	private void inintNotInputValue(List<Schema> schemas) {
		for (Schema schema : schemas) {
			if (schema .getClass().isAssignableFrom(SchemaL.class)) {
				SchemaL schemaL = (SchemaL) schema;
				schemaL.setValue(schemaL.getValue().isEmpty() ? schemaL.getDefault() : schemaL.getValue());
			}
			if (schema .getClass().isAssignableFrom(SchemaP.class)) {
				SchemaP schemaP = (SchemaP) schema;
				schemaP.setValue(schemaP.getValue().isEmpty() ? schemaP.getDefault() : schemaP.getValue());
			}
			if (schema .getClass().isAssignableFrom(SchemaD.class)) {
				SchemaD schemaD = (SchemaD) schema;
				schemaD.setValue(schemaD.getValue().isEmpty() ? schemaD.getDefault() : schemaD.getValue());
			}
		}
	}

	private List<String> splitInput(String input) {
		if (null == input || input.length() <= 0) {
			return new ArrayList<String>();
		}
		String[] params = input.trim().split(" "); 		 
		return Arrays.asList(params);
	}
}
