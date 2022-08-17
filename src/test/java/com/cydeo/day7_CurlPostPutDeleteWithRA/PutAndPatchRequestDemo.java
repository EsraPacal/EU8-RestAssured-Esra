package com.cydeo.day7_CurlPostPutDeleteWithRA;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PutAndPatchRequestDemo extends SpartanTestBase {


    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void PUTRequest(){

        //just like post request we have different options to send body, we will go with map
        Map<String,Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name","JohnLock");
        putRequestMap.put("gender","Male");
        putRequestMap.put("phone",8877411111L);

        given().and().contentType(ContentType.JSON)//  hey api i'm sending JSON body
                .body(putRequestMap)
                .and().pathParam("id",116)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //the above lines are the request body  <-------

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send


    }

    @DisplayName("PATCH request to one spartan for update with Map")
    @Test
    public void PATCHRequest() {

        //just like post request we have different options to send body, we will go with map
        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("phone", 8877411111L);

        given().and().contentType(ContentType.JSON)//  hey api i'm sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id", 116)
                .when().patch("/api/spartans/{id}")  // use "patch" param.here for updating partially  <----
                .then()
                .statusCode(204);

        //the above lines are the request body  <-------

    }

    @Test
    public void DELETESpartan(){
        int idToDelete = 115;

        given().pathParam("id",idToDelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);
    }


}
