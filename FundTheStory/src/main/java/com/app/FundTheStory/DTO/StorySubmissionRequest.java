package com.app.FundTheStory.DTO;


import com.app.FundTheStory.Entities.Campaign;
import com.app.FundTheStory.Entities.campaignCategory;
import com.app.FundTheStory.Entities.Story;

public class StorySubmissionRequest {

    private Story story;
    private campaignCategory category;
    private Campaign campaign;

    public StorySubmissionRequest(Story story, campaignCategory category, Campaign campaign){
        this.story = story;
        this.category = category;
        this.campaign = campaign;
    }


    public Story getStory(){
        return story;
    }
    public Campaign getCampaign(){
        return campaign;
    }
    public campaignCategory getCategory(){
        return category;
    }

    public void setStory(Story story){
        this.story = story;
    }
    public void setCampaign(Campaign campaign){
        this.campaign = campaign;
    }
    public void setCategory(campaignCategory category){
        this.category = category;
    }
}
