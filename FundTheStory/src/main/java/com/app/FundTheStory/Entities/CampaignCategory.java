package com.app.FundTheStory.Entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CampaignCategory {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String category;


    @OneToMany(mappedBy = "campaignCategory")
    private List<Campaign> campaigns;


    public CampaignCategory(String category){
        this.category = category;
    }

    public CampaignCategory(String category, List<Campaign> campaigns){
        this.category = category;
        this.campaigns = campaigns;
    }

    public Long getId(){
        return id;
    }
    public String getCategory(){
        return category;
    }

    public List<Campaign> getCampaigns(){
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns){
        this.campaigns = campaigns;
    }

    public void setCategory(String category){
        this.category = category;
    }

}