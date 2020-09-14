package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchemaCheck {
	static Schema schema = new Schema();
	public static void main(String[] args) {
		String inputParam = "-l true -p -d";
		try {
			schemaDetailCheck(inputParam);
		} catch (Exception e) {
			throw e;
		}
		
	}
	private static Map<String, Object> schemaDetailCheck(String inputParam) {
		//处理输入参数
		List<String> inputParams = deatilInputParam(inputParam);
		//
		Map<String, Object> checkResult = schemaCheck(inputParams);
		if (!CodeValueContant.SUCCESS.equals(checkResult.get(CommandValueContant.CODE))) {						
			try {
				throw new Exception(checkResult.get(CommandValueContant.MESSAGE).toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		checkResult.remove(CommandValueContant.CODE);
		return checkResult;

	}

	private static  Map<String, Object>  schemaCheck(List<String> inputParams) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (null == inputParams || inputParams.size() == 0) {
			resultMap.put("-l", true);
			resultMap.put("-p", 8080);
			resultMap.put("-d", "");
			resultMap.put(CommandValueContant.CODE, CodeValueContant.SUCCESS);
			return resultMap;
		}
		Schema schema = new Schema();
		List<String> shcemas = Arrays.asList(schema.getSchema());
		for (int i = 0; i < inputParams.size(); i++) {
			if (i == 0 && !shcemas.contains(inputParams.get(i))) {
				resultMap.put(CommandValueContant.CODE, CodeValueContant.FAIL);
				resultMap.put(CommandValueContant.MESSAGE, "输入不合法");
				return resultMap;
			}
			//当前字符为shemale时，判断下一字符是否为schema，是，则当前schema附默认值，否则判断类型是否正确
			if (shcemas.contains(inputParams.get(i))) {				
				//下一字符是schema时，当前schema附默认值
				if (i == inputParams.size() - 1 || shcemas.contains(inputParams.get(i + 1))) {
					//获取默认schema值
					resultMap = getSchemaValue(inputParams.get(i).replace("-", ""),resultMap);
					if (!CodeValueContant.SUCCESS.equals(resultMap.get(CommandValueContant.CODE))) {
						return resultMap;
					}
				}			
			}else {
				//当前字符是非schema时，判断类型并赋值
				resultMap = checkAndInit(inputParams.get(i -1).replace("-", ""),inputParams.get(i),resultMap);
				if (!CodeValueContant.SUCCESS.equals(resultMap.get(CommandValueContant.CODE))) {
					return resultMap;
				}				
			}
		}
		//处理未输入schema值
		initNotInputSchema(resultMap);		
		resultMap.put(CommandValueContant.CODE, CodeValueContant.SUCCESS);
		return resultMap;

	}

	private static void initNotInputSchema(Map<String, Object> resultMap) {
		if (!resultMap.containsKey("-l")) {
			resultMap.put("-l", schema.getlValue());
		}
		if (!resultMap.containsKey("-p")) {
			resultMap.put("-p", schema.getpValue());
		}
		if (!resultMap.containsKey("-d")) {
			resultMap.put("-d", schema.getdValue());
		}
	}
	private static Map<String, Object> checkAndInit(String schemaKey, String schemaValue, Map<String, Object> resultMap) {
		switch (schemaKey) {
		case "l":
			if ("true".equals(schemaValue) || "false".equals(schemaValue)) {
				resultMap.put("-l", Boolean.valueOf(schemaValue));
			}else {
				resultMap.put(CommandValueContant.CODE, CodeValueContant.FAIL);
				resultMap.put(CommandValueContant.MESSAGE, "输入不合法");
			}
			break;
		case "p":
			try {
				Integer.valueOf(schemaValue);
				resultMap.put("-p", schemaValue);
			} catch (Exception e) {
				resultMap.put(CommandValueContant.CODE, CodeValueContant.FAIL);
				resultMap.put(CommandValueContant.MESSAGE, "输入不合法");				
			}
			break;
		case "d":
			resultMap.put("-d", schemaValue);
			break;
		default:
			resultMap.put(CommandValueContant.CODE, CodeValueContant.FAIL);
			resultMap.put(CommandValueContant.MESSAGE, "输入不合法");
			break;
		}
		resultMap.put(CommandValueContant.CODE, CodeValueContant.SUCCESS);
		return resultMap;	
	}
	
	private static Map<String, Object> getSchemaValue(String schemaKey, Map<String, Object> resultMap) {
		switch (schemaKey) {
		case "l":
			resultMap.put("-l", schema.getlValue());
			break;
		case "p":
			resultMap.put("-p", schema.getpValue());
			break;
		case "d":
			resultMap.put("-d", schema.getdValue());
			break;
		default:
			resultMap.put(CommandValueContant.CODE, CodeValueContant.FAIL);
			resultMap.put(CommandValueContant.MESSAGE, "输入不合法");
			return resultMap;	
		}
		resultMap.put(CommandValueContant.CODE, CodeValueContant.SUCCESS);
		return resultMap;
	}
	
	private static List<String> deatilInputParam(String inputParam) {
		if (null == inputParam || inputParam.length() <= 0) {
			return new ArrayList<String>();
		}
		String[] params = inputParam.trim().split(" "); 		 
		return Arrays.asList(params);
	}

}
