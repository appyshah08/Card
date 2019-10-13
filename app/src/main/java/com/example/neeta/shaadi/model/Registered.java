package com.example.neeta.shaadi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Neeta on 10/9/2019.
 */

public class Registered {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
