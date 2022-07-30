package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestBase {


    @BeforeAll
    public static void init(){

        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://54.152.94.133:8000";
    }
}