package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LocalAPITest {
    @Test
    public void getAllUsers(){
        baseURI = "http://localhost:3000" ;
        given().
                get("/users").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void postNewUser(){
        JSONObject request = new JSONObject() ;
        request.put("firstName" , "yusuf") ;
        request.put("lastName" , "moftah") ;
        request.put( "subjectId" , 1) ;

        baseURI = "http://localhost:3000" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all() ;
    }
    @Test
    public void updateUserDetails(){
        JSONObject request = new JSONObject() ;
        request.put("firstName" , "ahmed") ;
        request.put("lastName" , "lotfy") ;
        request.put( "subjectId" , 1) ;

        baseURI = "http://localhost:3000" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/users/1").
        then().
                statusCode(200).
                log().all() ;
    }
    @Test
    public void patchUserDetails(){
        JSONObject request = new JSONObject() ;
        //request.put("firstName" , "ahmed") ;
        request.put("lastName" , "moftah") ;
        //request.put( "subjectId" , 1) ;

        baseURI = "http://localhost:3000" ;
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("/users/1").
        then().
                statusCode(200).
                log().all() ;
    }
    @Test
    public void deleteUser(){
        baseURI = "http://localhost:3000" ;
        when().
                delete("/users/9371").
        then().
                statusCode(200).
                log().all() ;
    }


}
