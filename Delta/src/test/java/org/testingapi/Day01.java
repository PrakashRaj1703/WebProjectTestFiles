package org.testingapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Day01 {

	@org.testng.annotations.Test(enabled = false)
	public void getAllEmployess() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "https://api.restful-api.dev/";
		RequestSpecification reqspec = RestAssured.given();
		Response request = reqspec.request(Method.DELETE, "objects/7");

		reqspec.header("Content-Type", "application/json")
				.body("{\r\n" + "   \"name\": \" Poco 16\",\r\n" + "   \"data\": {\r\n" + "      \"year\": 2019,\r\n"
						+ "      \"price\": 1849.99,\r\n" + "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"1 TB\"\r\n" + "   }\r\n" + "}");

		String asprettyString = request.asPrettyString();
		System.err.println(asprettyString);
		int statusCode = request.getStatusCode();
		System.out.println(statusCode);
	}

	@org.testng.annotations.Test(enabled = false)
	public void serialization() {
		RestAssured.useRelaxedHTTPSValidation();

		Map<String, Object> jsonBody = new HashMap<String, Object>();
		List<String> s = new ArrayList<String>();
		// jsonBody.put("id", "14");
		jsonBody.put("name", "Prakash");
		// jsonBody.put("Email", "videomemes17@gmail.con");
		s.add("java");
		s.add("Selenium");
		s.add("Cucumber");
		jsonBody.put("data", s);
		System.out.println(jsonBody);

		given().baseUri("https://api.restful-api.dev/").headers("Contant-Type", "application/json").body(jsonBody).log()
				.all().when().post("objects").then().log().all();
	}

	@org.testng.annotations.Test(enabled = false)
	public void delete() {
		RestAssured.useRelaxedHTTPSValidation();
		given().baseUri("https://api.restful-api.dev/").when().delete("objects/13").prettyPrint();
	}

	@org.testng.annotations.Test(enabled = false)
	public void getdatas() {
		RestAssured.useRelaxedHTTPSValidation();
		given().baseUri("https://api.restful-api.dev/").when().get("objects").prettyPrint();
	}

	@org.testng.annotations.Test(enabled = false)
	public void postdatas() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = (Response) given().baseUri("https://api.restful-api.dev")
				.headers("Content-Type", "application/json")
				.body("{\r\n" + "   \"name\": \"Apple\",\r\n" + "   \"data\": {\r\n" + "      \"year\": 2019,\r\n"
						+ "      \"price\": 2049.99,\r\n" + "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"100 TB\",\r\n" + "      \"color\": \"silver\"\r\n" + "   }\r\n"
						+ "}")
				.when().post("/objects").then().log().status().extract().response();
		System.err.println(response.getStatusCode());
		System.err.println(response.asPrettyString());

	}

	@org.testng.annotations.Test(enabled = false)
	public void putUpdatedatas() {
		RestAssured.useRelaxedHTTPSValidation();
		Response s = given().baseUri("https://api.restful-api.dev").contentType("application/json")// headers("Content-Type",
																									// "application/json")
				.body("{\r\n" + "   \"name\": \"Apple MacBook Pro 16\",\r\n" + "   \"data\": {\r\n"
						+ "      \"year\": 2019,\r\n" + "      \"price\": 2049.99,\r\n"
						+ "      \"CPU model\": \"Intel Core i9\",\r\n" + "      \"Hard disk size\": \"1 TB\",\r\n"
						+ "      \"color\": \"silver\"\r\n" + "   }\r\n" + "}")
				.when().put("objects/ff8081819782e69e01982822a8d91bcb").then().log().status().extract().response();
		System.err.println("Status" + s.asPrettyString() + s.getStatusCode());
	}

	@org.testng.annotations.Test
	public void deleteAPI() {
		RestAssured.useRelaxedHTTPSValidation();
		Response r = given().baseUri("https://api.restful-api.dev/").when().delete("objects/3").then().log().status()
				.extract().response();
		System.err.println("Status" + r.asPrettyString() + r.getStatusCode() + r.prettyPrint());
	}

}
