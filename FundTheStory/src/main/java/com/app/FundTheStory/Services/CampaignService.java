package com.app.FundTheStory.Services;


import com.app.FundTheStory.Entities.Campaign;
import com.app.FundTheStory.Entities.campaignCategory;
import com.app.FundTheStory.Entities.Story;
import com.app.FundTheStory.DTO.StorySubmissionRequest;
import com.app.FundTheStory.Repositories.CampaignCategoryRepository;
import com.app.FundTheStory.Repositories.CampaignRepository;
import com.app.FundTheStory.Repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    CampaignCategoryRepository campaignCategoryRepository;

    public List<Campaign> getCampaigns(){
        return campaignRepository.findAll();
    }

    public void addCampaign(StorySubmissionRequest submissionRequest){
        Story story = submissionRequest.getStory();
        campaignCategory category = submissionRequest.getCategory();
        Campaign campaign = submissionRequest.getCampaign();

        Story savedstory = storyRepository.save(story);
        campaignCategory savedCategory = campaignCategoryRepository.save(category); // TODO: Check DB before inserting category
        campaign.setStory(savedstory);
        campaign.setCampaignCategory(savedCategory);
        campaignRepository.save(campaign);

    }
}
