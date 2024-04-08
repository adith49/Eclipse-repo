package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;

import org.openqa.selenium.devtools.v115.cachestorage.model.Header;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	@Test
	void headersDemo() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");
		
	}
	
	@Test
	void getHeaders() {
		
		Response response = given()
		
		.when()
		.get("https://www.google.com/");
		
		//get single header info
		String header_value=response.getHeader("Content-Type");
		System.out.println(header_value);
		
		//get all header info    //this is not a hashmap
		Headers myheaders=response.getHeaders();
	
		for (io.restassured.http.Header hd:myheaders) 
		{
		System.out.println(hd.getName()+"    "+hd.getValue());	
		}
		
	
	
	}
	
	
	
	
	
}
