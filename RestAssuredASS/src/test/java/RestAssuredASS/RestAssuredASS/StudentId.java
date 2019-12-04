package RestAssuredASS.RestAssuredASS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class StudentId {

	public static void main(String[] args) {
		/*
		 * URL url=new URL("https://jsonplaceholder.typicode.com/posts");
		 * HttpURLConnection conn=(HttpURLConnection)url.openConnection(); // GET
		 * request conn.setRequestMethod("GET"); conn.connect();
		 * 
		 * //Get the corresponding response code.
		 * 
		 * int responsecode=conn.getResponseCode(); if(responsecode !=200) throw new
		 * RuntimeException("HttpResponseCode:" +responsecode); else { }
		 * 
		 * JSONParser parse= new JSONParser();
		 * 
		 */
		/*
		 * try { URL url = new URL("https://jsonplaceholder.typicode.com/posts");
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(url.openStream())); String str = ""; while (null != (str =
		 * br.readLine())) { System.out.println(str); } } catch (Exception ex) {
		 * 
		 * StringBuffer idvalue=new StringBuffer(); JSONArray obj_JSONArray=new
		 * JSONArray(); for (int i=0;i<obj_JSONArray.size();i++);
		 */

		Response response = given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200)
				.contentType("application/json").assertThat()

				.extract().response();
		// System.out.println(str);
		// JsonPath path=new JsonPath (str);*/
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RequestSpecification request = RestAssured.given();

		// JSONObject requestParams = new JSONObject();
		Response response1 = request.get("/");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		// List<String> userIds = jsonPathEvaluator.get("userId");
		// System.out.println(userIds);
		// int statusCode = response.getStatusCode();
		// Assert.assertTrue(userIds.contains(7));

		// Assert.assertEquals("hi", userzIds);
		List<HashMap<String, String>> jsonresponse = response.jsonPath().get("$");
		for (int i = 0; i < jsonresponse.size(); i++) {
			String userid = String.valueOf(jsonresponse.get(i).get("userid"));
			if (userid.contentEquals("7"))
				System.out.println(jsonresponse.get(i).get("title"));

		}
	}

}
