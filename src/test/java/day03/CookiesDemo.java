package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	//@Test
	void cookiesDemo() {
	given()
	
	.when()
	.get("https://www.google.com/")
	
	.then()
	.cookie("key","value")
	.log().all();

	}
	
	@Test
	void getCookiesInfo() {
	
		Response response = given()
		
	.when()
	.get("https://www.google.com/");
		
		//get single cookie info
		String cookie_value = response.getCookie("AEC");
		System.out.println("Value of cookie is ===> "+cookie_value);

		//get all cookie info
		Map<String, String> cookie_values = response.getCookies();
		//System.out.println(cookie_values.keySet());
		for (String k : cookie_values.keySet()) 
		{
			System.out.println(k+" ====> "+cookie_value);
		}
	
	}
	
}
