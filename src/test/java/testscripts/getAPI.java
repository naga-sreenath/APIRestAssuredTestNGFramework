package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import jdk.internal.org.jline.utils.Log;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
public class getAPI {
	
	@Test (priority=1)
	public void getUserInPageTwo()
	{
		
		Response response = given().when().get("https://reqres.in/api/users/2");
		
		int actualstatus = response.statusCode();
		
		Assert.assertEquals(actualstatus, 200);
		
		String actualresponse = response.asString();
		
		System.out.println("response is->"+actualresponse);
		
		JsonPath js= new JsonPath(actualresponse);
		
		int id =js.get("data.id");
		String email= js.get("data.email");
		
		System.out.println("id value is->"+id);
		System.out.println("email value is->"+email);
		
		Assert.assertEquals(id, 2);
		
		Assert.assertEquals(email, "janet.weaver@reqres.in");

		
	

}
}