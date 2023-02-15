package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;


public class Authentication {

    public static String generateToken() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("1","api","2","authenticate");

        String username = "";
        String password = "";

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password",password);
        map.put("rememberme","true");


        Response response1 = given().spec(spec).contentType(ContentType.JSON).body(map).when().post("/{1}/{2}");

        JsonPath token = response1.jsonPath();

        return token.getString("id_token");
    }

}
