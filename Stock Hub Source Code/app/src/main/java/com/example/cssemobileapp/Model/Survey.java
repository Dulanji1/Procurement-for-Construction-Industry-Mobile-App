package com.example.cssemobileapp.Model;

import java.util.ArrayList;
import java.util.Date;

public class Survey {
    private String name;
    private Date lastModified;

    public Survey(String name, Date lastModified) {
        this.name = name;
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public static ArrayList<Survey> createSurveyList(int numSurveys){
        ArrayList<Survey> surveys = new ArrayList<Survey>();

        for(int i = 0; i <= numSurveys; i++){
            surveys.add(new Survey("Survey" + Integer.toBinaryString(i), (new Date())));
        }

        return surveys;
    }
}
