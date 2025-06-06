package com.app.FundTheStory.Controllers;


import com.app.FundTheStory.Entities.Campaign;
import com.app.FundTheStory.DTO.StorySubmissionRequest;
import com.app.FundTheStory.Services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;


    @GetMapping("/getCampaigns")
    public List<Campaign> getCampaigns(){
        return campaignService.getCampaigns();
    };

    @PostMapping("/addCampaign")
    public void addCampaign(@RequestBody StorySubmissionRequest submissionRequest){
        campaignService.addCampaign(submissionRequest);
    }


}
