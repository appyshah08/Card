package com.example.neeta.shaadi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Neeta on 10/9/2019.
 */

public class Street {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
