package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {

    //BeforeAll is annotation equals to @BeforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method
        baseURI = "http://54.152.94.133:1000/ords/hr";

        //get ip address from configurations
    }
}
