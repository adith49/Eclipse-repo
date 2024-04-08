package day03;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PathAndQueryParam {
	
	@Test
	void testPathAndQueryParameters() 
	{
		
		given()
		.pathParam("mypath", "users") //Path parameter
		.queryParam("page", 2) //Query parameter
		.queryParam("id", 5) //Query parameter
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();

	}

}
