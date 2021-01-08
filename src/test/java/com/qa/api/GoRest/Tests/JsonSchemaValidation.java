package com.qa.api.GoRest.Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation 
{
	
	@Test(priority=1)
	public void GoRest_GetUsers_BDD() 
	{
		RestAssured.baseURI="https://gorest.co.in/";
		
		given().log().all()
		       .header("Authorization","Bearer 72dce4758349a370d59a85956c77f21c23d88e7b2d62f4af4d82c035ad095a3e").		      
		when().log().all().
				get("public-api/users/17").
		then().log().all().assertThat()
		.body(matchesJsonSchemaInClasspath("GetUser.json"));
				
	}

}
