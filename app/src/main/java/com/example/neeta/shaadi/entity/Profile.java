package com.example.neeta.shaadi.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Neeta on 10/9/2019.
 */

@Entity(tableName = "profile")
public class Profile {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;

    @ColumnInfo(name ="first_name")
    private String firstName;

    @ColumnInfo(name ="last_name")
    private String lastName;

    @ColumnInfo(name="gender")
    private String gender;

    @ColumnInfo(name="age")
    private int age;

    @ColumnInfo(name="city")
    private String city;

    @ColumnInfo(name="state")
    private String state;

   @ColumnInfo(name="country")
    private String country;

   @ColumnInfo(name="status")
    private int status;

   @ColumnInfo(name="profile_pic")
    private String profile_pic;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

}
