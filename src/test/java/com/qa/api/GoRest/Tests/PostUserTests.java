package com.qa.api.GoRest.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.gorest.testutils.TestUtils;
import com.qa.api.gosrest.pojo.Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostUserTests {
	
	
	@Test(priority=1)
	public void GoRest_GetUsers_Non_BDD() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		Users user=new Users("Jayanta","jkm12@gmail.com","Male","Active");
		String jsonVal=TestUtils.getSerializedJsonGson(user);
				
		RequestSpecification request=RestAssured.given().log().all();
		request.header("Authorization","Bearer 72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e");
		request.body(jsonVal);
		request.contentType(ContentType.JSON);
		
		Response response=request.post("/public-api/users");		
		
		System.out.println(response.prettyPrint());
	
		
	}

}
