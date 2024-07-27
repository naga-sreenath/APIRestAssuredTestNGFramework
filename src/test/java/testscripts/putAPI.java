package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import jdk.internal.org.jline.utils.Log;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
public class putAPI {
	
	
	@Test (priority=1)
	public void putSingleUser() {
		
	Response putresponse = given().when().put("https://jsonplaceholder.typicode.com/posts/1");
	
	int putstatus = putresponse.statusCode();
	
	Assert.assertEquals(putstatus, 200);
	
	String actualputresponse = putresponse.asString();
	
	System.out.println("response for put end point is->"+actualputresponse);
	
	JsonPath js= new JsonPath(actualputresponse);
	
	int id2 =js.get("id");
	
	System.out.println("id value is->"+id2);
	
	Assert.assertEquals(id2, 1);
	
			

}
}