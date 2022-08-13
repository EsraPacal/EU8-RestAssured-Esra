package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {

    //region_id
    //if your jsonkey  and variable name not matching, you can map it with jsonProperty
    @JsonProperty("region_id")  // this annotation provides a connection between "region_id" and "rId"
    private int rId;
    @JsonProperty("region_name")
    private String region_name;
    @JsonProperty("links")
    private List<Link> links;   // it's holding an array. So, we store the objects inside the List of Link. Even if there was only one object inside the array, we should store it inside the List.


}
