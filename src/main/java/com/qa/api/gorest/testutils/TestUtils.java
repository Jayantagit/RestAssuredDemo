package com.qa.api.gorest.testutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class TestUtils 
{
	/**
	 * Convert POJO to JSON using Jackson databind
	 * @param obj
	 * @return jsonString
	 */
	
	public static String getSerializedJsonJackson(Object obj)
	{
		ObjectMapper mapper=new ObjectMapper();
		String json=null;
		
		try 
		{
			json=mapper.writeValueAsString(obj);
		}
		catch (JsonProcessingException e) 
		{			
			e.printStackTrace();
		}
		return json;
	}
	
	public static String getSerializedJsonGson(Object obj)
	{
		Gson gson = new Gson(); 
		String jsonString=null;
		
		jsonString=gson.toJson(obj);
		
		return jsonString;
	}

}
