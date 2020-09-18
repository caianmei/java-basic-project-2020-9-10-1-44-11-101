package com.thoughtworks.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Arg {

	public void arg(List<Schema> schemas) {
		repeatKeyCheck(schemas);
		undefinedSchemaCheck(schemas);
		valueTypeCheck(schemas);		
	}

	public void valueTypeCheck(List<Schema> schemas) {
		for (Schema schema : schemas) {
			if (schema.getClass().isAssignableFrom(SchemaL.class) && !schema.judgeValueType()) {
				throw new SchemaException(CodeValueContant.SCHEMA_L + "schema值类型错误");
			}
			if (schema.getClass().isAssignableFrom(SchemaP.class)&& !schema.judgeValueType()) {
				throw new SchemaException(CodeValueContant.SCHEMA_P + "schema值类型错误");
			}
			if (schema.getClass().isAssignableFrom(SchemaD.class)&& !schema.judgeValueType()) {
				throw new SchemaException(CodeValueContant.SCHEMA_D + "schema值类型错误");
			}
		}

	}

	public void undefinedSchemaCheck(List<Schema> schemas) {
		for (Schema schema : schemas) {
			if (schema .getClass().isAssignableFrom(SchemaUnkown.class)) {
				throw new SchemaException("存在未知schema，请核实");
			}
		}
	}

	public void repeatKeyCheck(List<Schema> schemas) {
		Map<String,Integer> keyMap = new HashMap<>();
		for (Schema schema : schemas) {
			if (schema .getClass().isAssignableFrom(SchemaL.class)) {
				keyMap.put(CodeValueContant.SCHEMA_L, keyMap.get(CodeValueContant.SCHEMA_L) == null ? 1 : keyMap.get(CodeValueContant.SCHEMA_L) + 1);
			}
			if (schema .getClass().isAssignableFrom(SchemaP.class)) {
				keyMap.put(CodeValueContant.SCHEMA_P, keyMap.get(CodeValueContant.SCHEMA_P) == null ? 1 : keyMap.get(CodeValueContant.SCHEMA_P) + 1);
			}
			if (schema .getClass().isAssignableFrom(SchemaD.class)) {
				keyMap.put(CodeValueContant.SCHEMA_D, keyMap.get(CodeValueContant.SCHEMA_D) == null ? 1 : keyMap.get(CodeValueContant.SCHEMA_D) + 1);
			}
		}
		for (Entry<String, Integer> entry : keyMap.entrySet()) {
			if (entry.getValue() > 1) {
				throw new SchemaException(entry.getKey()+ "schema重复");
			} 
		}
	}
}
