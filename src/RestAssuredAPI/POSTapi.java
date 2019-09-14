package RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;


public class POSTapi {
  @Test
  public void success() {
	  RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	  RequestSpecification request = RestAssured.given();
	  JSONObject reqparam = new JSONObject();
	  reqparam.put("title", "foo");
	  reqparam.put("body", "bar");
	  reqparam.put("userId",1);
	  
	  request.header("Content-type","application/json");
	  request.header("charset","UTF-8");
	  request.body(reqparam.toJSONString());
	  Response response = request.post("/posts");
	  
	  //validation of response code
	  int statuscode = response.getStatusCode();
	  Assert.assertEquals(statuscode, 200);
	  System.out.println("response code is:"+ statuscode);
	  
	  //validation of response parameters
	  String responsebody = response.getBody().asString();
	  System.out.println("response body is:"+ responsebody);
	  
	  JsonPath jsonparser = response.jsonPath();
	  Assert.assertNotEquals(jsonparser.get("title"),"title value is null");
	  Assert.assertNotEquals(jsonparser.get("body"),"title value is null");
	  Assert.assertNotEquals(jsonparser.get("userId"),"title value is null");
	  Assert.assertNotEquals(jsonparser.get("id"),"title value is null");
	  }
  
}
