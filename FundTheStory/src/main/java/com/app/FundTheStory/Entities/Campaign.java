package com.app.FundTheStory.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private double goalAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "campaign_category_id")
    private campaignCategory campaignCategory;

    @OneToOne
    @JoinColumn(name = "story_id",unique = true)
    private Story story;



    // No args Constructor for JPA
    public Campaign(){}


    public Campaign(Story story,double goalAmount, LocalDate startDate, LocalDate endDate){      // TODO: Start date and End date will be decided by the system
        this.story = story;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = story.getTitle();
    }


    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public double getGoalAmount(){
        return goalAmount;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public campaignCategory getCampaignCategory(){
        return campaignCategory;
    }

    public Story getStory(){
        return story;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setGoalAmount(double goalAmount){
        this.goalAmount = goalAmount;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public void setCampaignCategory(campaignCategory category){
        this.campaignCategory = category;
    }

    public void setStory(Story story){
        this.story = story;
        setTitle(story.getTitle());
    }
}
