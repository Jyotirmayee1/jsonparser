package RestAssuredASS.RestAssuredASS;

//import junit.framework.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
//import static org.hamcrest.Matchers.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
  
    @Test
    public void testStudenIdIs7() {
    	
    	Response response = given()
				.when()
				.get
				("https://jsonplaceholder.typicode.com/posts")
				.then()
				.statusCode(200).contentType("application/json")
				.assertThat()
				
				.extract().response();
    	//System.out.println(str);
    	//JsonPath path=new JsonPath (str);*/
    	RestAssured.baseURI ="https://jsonplaceholder.typicode.com/posts";
    	 RequestSpecification request = RestAssured.given();
    	 
    	 //JSONObject requestParams = new JSONObject();
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
    	 List<HashMap<String,String>> jsonresponse=response.jsonPath().get("$");
    	 for(int i=0;i<jsonresponse.size();i++) {
    		 String userid=String.valueOf(jsonresponse.get(i).get("userid"));
    		 if(userid.contentEquals("7"))
    			 System.out.println(jsonresponse.get(i).get("title"));
    		 
    		 
    		
    		 		
    	 }
    	 
    	 
            
}
    
    
}