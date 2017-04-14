package main.com.pro.tools;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class JsonTool {
	
	private JsonTool() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Map ToMap(String data){
		return (Map)JSONObject.parse(data);
	}

}
