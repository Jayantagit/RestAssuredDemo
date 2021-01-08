package com.qa.api.GoRest.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class GetUsers 
{
	
	@Test(priority=1)
	public void GoRest_GetUsers_Non_BDD() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		
		RequestSpecification request=RestAssured.given().log().all();
		request.header("Authorization","Bearer 72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e");
		
		Response response=request.get("public-api/users/5");
		
		JsonPath js=response.jsonPath();
		String gender=js.getString("data.gender");
		
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(gender, "Male");	
		
	}
	
	@Test(priority=2)
	public void GoRest_GetUsers_BDD() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		
		given().log().all().
		       auth().oauth2("72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e").
		when().log().all().
				get("public-api/users/5").
		then().log().all().assertThat().statusCode(200).and().
		body("data.status",equalTo("Inactive"));        
				
	}
	
	@Test(priority=3)
	public void GoRest_GetUsers_BDD_Extract() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		
		String status=given().log().all().
		       auth().oauth2("72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e").
		when().log().all().
				get("public-api/users/5").
		then().log().all().assertThat().extract().path("data.status");
		
		Assert.assertEquals(status,"Inactive");	
		
				
	}
	
	@Test(priority=4)
	public void GoRest_GetUsers_BDD_MapUsage() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		
		JsonPath jsonPath=given().log().all().
		       auth().oauth2("72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e").
		when().log().all().
				get("public-api/users/9").
							then().extract().jsonPath();
	Map<Object,Object> map=jsonPath.getMap("data");
	
	  System.out.println("=====================");	
	  
	  for(Object o:map.keySet())
	  {
		  System.out.println("Key is"+ o+" value is:" +  map.get(o));
	  }
	  
	System.out.println("Email is="+ map.get("email").toString());	 
		
				
	}

	

}
