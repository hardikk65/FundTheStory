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
import java.util.Objects;
import java.util.Optional;

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

        // Saves Story in DB
        Story savedstory = storyRepository.save(story);

        // Fetches the Category from DB
        List<campaignCategory> savedCategories = campaignCategoryRepository.findAll();

        // Searches for Existing Category in DB
        Optional<campaignCategory> existingCategory = savedCategories.stream()
                .filter(c -> Objects.equals(c.getCategory(), category.getCategory()))
                .findFirst();

        // Saves Category in DB
        campaignCategory savedCategory = existingCategory
                .orElseGet(() -> campaignCategoryRepository.save(category));

        //Calling Setters
        campaign.setStory(savedstory);
        campaign.setCampaignCategory(savedCategory);

        // Saving Campaign in DB
        campaignRepository.save(campaign);

    }
}
