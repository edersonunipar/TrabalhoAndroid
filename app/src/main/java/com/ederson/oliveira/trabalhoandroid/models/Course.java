package com.ederson.oliveira.trabalhoandroid.models;

import java.util.List;

/**
 * Created by aluno on 16/04/18.
 */

public class Course {
    private long id;

    public String title;

    public String subtitle;

    public List<Instructor> instructors;

    public Course(){

    }

    public Course(long id, String title,String subtitle){
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title){this.title = title;}

    public String getSubtitle() { return subtitle; }

    public void setSubtitle(String subtitle){this.subtitle= subtitle;}



}
