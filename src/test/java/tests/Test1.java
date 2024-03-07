package tests;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {
    @Test
    public void t1(){
        Response response = get("https://reqres.in/api/users?page=2") ;
        System.out.println( response.getStatusCode() );
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void t2(){
        baseURI = "https://reqres.in/api" ;
        given().
                get("users/23").
        then().
                statusCode(404);

    }
    @Test
    public void getStatus(){
        baseURI = "https://simple-books-api.glitch.me" ;
        given().
                get("/status").
        then().
                body("status" , equalTo("OK")).
                log().all() ;
    }
    @Test
    public void getListOfBooks(){
        baseURI = "https://simple-books-api.glitch.me" ;
        given().
                get("/books").
        then().
                body("[1].name" , equalTo("Just as I Am")).
                log().all() ;
    }
    @Test
    public void getUsers(){
        baseURI = "http://localhost:3000" ;
        given().
                get("/users").
        then().
                log().all();
    }

}
