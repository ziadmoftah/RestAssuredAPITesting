package tests;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetAndPost {
    @Test
    public void testGet(){
        baseURI = "https://reqres.in/api" ;
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data.first_name" , hasItem("Michael")) ;
    }
    @Test
    public void testPost(){
        JSONObject request = new JSONObject() ;
        request.put("name" , "moftah") ;
        request.put("job" , "3atel") ;
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api" ;

        given().
                //header("Content-Type" , "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }
}
