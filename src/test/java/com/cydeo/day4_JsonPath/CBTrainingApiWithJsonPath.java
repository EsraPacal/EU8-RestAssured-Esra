package com.cydeo.day4_JsonPath;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class CBTrainingApiWithJsonPath {

    //BeforeAll is annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we don't need to type each http method
        baseURI = "http://api.cybertektraining.com";

    }

    @DisplayName("GET request to individual student")
    @Test
    public void test1(){
        //send a get request to student id 23401 as a path parameter and accept header application/json
        //verify status code/ content type /Content-Encoding = gzip
        //verify Date header exists
        //assert that
               /*
                   firstName Vera
                   batch 14
                   section 12
                   emailAddress = aaa@gmail.com
                   companyName = Cybertek
                   state = IL
                   zipCode = 60606

                   using JsonPath


               */
    }
}
