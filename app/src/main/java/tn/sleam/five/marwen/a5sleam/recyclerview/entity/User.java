package tn.sleam.five.marwen.a5sleam.recyclerview.entity;

/**
 * Created by marwen on 10/6/17.
 */

public class User {

    String name, country;

    public User(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
