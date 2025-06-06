package com.app.FundTheStory.Entities;

import jakarta.persistence.*;

@Entity
public class Story{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;

    @OneToOne(mappedBy = "story")
    private Campaign campaign;

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
    public Campaign getCampaign(){
        return campaign;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setCampaign(Campaign campaign){   // Functionality may not be needed
        this.campaign = campaign;
    }



}