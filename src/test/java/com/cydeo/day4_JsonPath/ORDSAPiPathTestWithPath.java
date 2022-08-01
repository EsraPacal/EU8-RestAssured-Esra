package com.cydeo.day4_JsonPath;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSAPiPathTestWithPath extends HRTestBase {

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        //print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first countryId
        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

        //print second coutryName
        System.out.println("response.path(\"items[1].country_name\") = " + response.path("items[1].country_name"));

        //print "http://54.152.94.133:1000/ords/hr/countries/CA"

        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("href = " + thirdHref);

        //get me all the countries' name
        //List<String> countryNames = response.path("items.country_name");
        //System.out.println("countryNames = " + countryNames);   ---------> second option
        System.out.println("response.path(\"items.country_name\") = " + response.path("items.country_name"));

        //assert that all regions ids are equals to 2
        List<Integer> allRegionsIDs = response.path("items.regions_id");
        for (Integer regionsID : allRegionsIDs) {
            System.out.println("regionsID = " + regionsID);
            assertEquals(2,regionsID);

        }
    }

    @DisplayName("GET request to /employees with QUERY Param")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\": \"IT_PROG\"}")
                .when()
                .get("/employees");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));

        //make sure we have only IT_PROG  as a job_id
        List<String> allJobIDs = response.path("items.job_id");

        for (String jobID : allJobIDs) {
            System.out.println("jobID = " + jobID);
            assertEquals("IT_PROG",jobID);
        }

        //TASK
        //print name of each IT_PROGs


    }
}
