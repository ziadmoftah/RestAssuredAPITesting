package tests;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class SOAPRequest {
    @Test
    public void validateSoapXML() throws IOException {
        File file = new File("./SoapRequest/add.xml") ;
        FileInputStream fileInputStream = fileInputStream = new FileInputStream(file) ;


        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
        baseURI = "http://dneonline.com" ;

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).
                log().all().
        and().
                body("//*:AddResult.text()" , equalTo("11")) ;
    }
}
