package com.thoughtworks.basic;

public class SchemaFactoryImpl implements SchemaFactroy {

	@Override
	public Schema getSchema(String valueType) {
		switch(valueType){
		case CodeValueContant.SCHEMA_L:			
			return new SchemaL();
		case CodeValueContant.SCHEMA_P:
			return new SchemaP();
		case CodeValueContant.SCHEMA_D:
			return new SchemaD();
		default:
			return new SchemaUnkown();
		}		
	}
}
	
