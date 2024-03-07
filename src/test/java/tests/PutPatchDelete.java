package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PutPatchDelete {
    @Test
    public void testPut(){
        JSONObject request = new JSONObject() ;
        request.put("name" , "moftah");
        request.put("job" , "zion resident") ;
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("users/2").
        then().
                statusCode(200).
                log().all();

    }
    @Test
    public void testPatch(){
        JSONObject request = new JSONObject() ;
        request.put("name" , "moftah");
        request.put("job" , "zion resident") ;
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("users/2").
        then().
                statusCode(200).
                log().all();

    }
    @Test
    public void testDelete(){
        baseURI= "https://reqres.in" ;

        given().
                delete("/api/users/2").
        then().
                statusCode(204).
                log().all();
    }
}
