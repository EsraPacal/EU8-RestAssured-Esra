package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestBase {


    @BeforeAll
    public static void init(){

        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://54.152.94.133:8000";
        //get ip address from configurations

        String dbUrl = "jdbc:oracle:thin:@54.152.94.133:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);


    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }

}
