package test;

import java.util.Map;

import org.junit.Test;
import main.com.pro.tools.JsonTool;

public class TestJsonTool {
	
	
	
	@Test
	public void TestToMap(){
		String data = "{\"key\":\"value\"}";
		Map map = JsonTool.ToMap(data);
		System.out.println(map);
	}

}
