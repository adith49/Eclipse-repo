package day02;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;


public class DiffPost {
	//1. POST Request body using HashMap
	//	@Test
	void TestUsingHashMap() 

	{
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");

		String courseArr[] = {"C","C++"};
		data.put("courses", courseArr);

		given()
		.contentType("application/json")
		.body(data)

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("name", equalTo("Scott"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();		

	}

	//2. POST Request body using Org.Json
	//Org.Json library should be added to POM.xml
	void TestUsingOrgJson() 

	{
		JSONObject jdata = new JSONObject();

		jdata.put("name","Scott");
		jdata.put("location","France");
		jdata.put("phone","123456");

		String courseArr[] = {"C","C++"};
		jdata.put("courses", courseArr);

		given()
		.contentType("application/json")
		.body(jdata.toString()) //When using Org.Json, use toString() to send body request

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("name", equalTo("Scott"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();		

	}

	//3. POST Request body using POJO class
	void TestUsingPojoClass() 

	{
		PojoClass pdata = new PojoClass();

		pdata.setName("Scott");
		pdata.setLocation("France");
		pdata.setPhone("123456");

		String courseArr[] = {"C","C++"};
		pdata.setCourses(courseArr);

		given()
		.contentType("application/json")
		.body(pdata.toString()) //When using Org.Json, use toString() to send body request

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("name", equalTo("Scott"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();		

	}

	//4. POST Request body using json file
	void TestUsingJsonFile() throws FileNotFoundException 

	{
		File file = new File(".\\body.json");

		FileReader reader = new FileReader(file);

		JSONTokener tokener = new JSONTokener(reader);

		JSONObject data = new JSONObject(tokener);



		given()
		.contentType("application/json")
		.body(data.toString()) //When using Org.Json, use toString() to send body request

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("name", equalTo("Scott"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();		

	}

}
