package com.app.FundTheStory.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Story{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty. ")
    private String title;


    @NotBlank(message = "Description cannot be empty. ")
    private String description;

    public Story(){}

    public Story(String title,String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }

}