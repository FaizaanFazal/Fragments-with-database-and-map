package com.example.finalexam181924;


public class userModel {
    String Name,Discription;

    public userModel(String name, String discription) {
        Name = name;
        Discription = discription;
    }

    public userModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }
}

