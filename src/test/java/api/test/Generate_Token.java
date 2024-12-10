package api.test;

import org.junit.Test;

import api.payload.tokenPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.Common_base;
import utilities.PathUrls;
import static io.restassured.RestAssured.*;

import java.io.IOException;


public class Generate_Token {
	
	@Test
	public String e_token() throws IOException {
		
		RestAssured.baseURI = Common_base.getEnvUrl("baseurl");
		String response = given().header("Content-Type", "application/json").body(tokenPayload.e_tokenPayload())
		.when().post(PathUrls.generatetoken.getPathUrl()).then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String token = js.get("token");
		System.out.println(token);	
		return response;
	}

}
