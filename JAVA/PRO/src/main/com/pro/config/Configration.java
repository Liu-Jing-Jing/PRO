package main.com.pro.config;

import java.util.HashMap;
import java.util.Map;


public class Configration {
	
	
	private Map<String, Object> InvokeClass = new HashMap<String, Object>();
	
	
	public void RegisterClass(String str,Object value){
		if(InvokeClass.containsKey(str)){
			throw new RuntimeException("one more key named "+ str +"hava registered!");
		}
		InvokeClass.put(str, value);
	}
	
	
	
	
	
	

}
