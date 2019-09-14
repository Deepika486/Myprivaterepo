package RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETapi {
  @Test
  public void successscenario() {
		
	  RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.request(Method.GET, "/posts/1");
	  String responseBody = response.getBody().asString();
	  int StatusCode = response.getStatusCode();
	  //validate status code is 200
	  Assert.assertEquals(StatusCode, 200);
	  System.out.println("Status code is: " + StatusCode);
	  
	  //validate response parameter values are not null
	  System.out.println("Response Body is " + responseBody);
	  JsonPath jsonparser = response.jsonPath();
	  Assert.assertNotNull(jsonparser.get("userId"), "response parameter userId is null");
	  Assert.assertNotNull(jsonparser.get("id"), "response parameter id is null");
	  Assert.assertNotNull(jsonparser.get("title"), "response parameter title is null");
	  Assert.assertNotNull(jsonparser.get("body"), "response parameter body is null");
	  }
}
