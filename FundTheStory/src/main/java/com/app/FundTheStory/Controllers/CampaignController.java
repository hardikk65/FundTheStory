package com.app.FundTheStory.Controllers;


import com.app.FundTheStory.Entities.Campaign;
import com.app.FundTheStory.DTO.StorySubmissionRequest;
import com.app.FundTheStory.Services.CampaignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;


    @GetMapping
    public List<Campaign> getCampaigns(){ // Display All listed Campaigns
        return campaignService.getCampaigns();
    }

    @PostMapping("/addCampaign")
    public ResponseEntity<?> addCampaign(@Valid @RequestBody StorySubmissionRequest submissionRequest){ // Create a New Campaign... This method requires the user to be Logged in
        campaignService.addCampaign(submissionRequest);
        return ResponseEntity.ok("Success!");
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Campaign>> filterByCategory(@RequestParam(required = false) String category){
        if(category == null || category.isEmpty()){
            return ResponseEntity.ok(campaignService.getCampaigns());
        }

        List<Campaign> campaigns = campaignService.filterByCategory(category);


        if(campaigns.isEmpty()){
            // How to write no campaign found;
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(campaigns);

    }
    @GetMapping("/filter")
    public ResponseEntity<List<Campaign>> filterByPrice(@RequestParam(required = false) Double minAmount,
                                                        @RequestParam(required = false) Double maxAmount){

        if(minAmount == null || maxAmount == null){
            return ResponseEntity.ok(campaignService.getCampaigns());
        }

        List<Campaign> campaigns = campaignService.filterByPrice(minAmount, maxAmount);
        if(campaigns.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(campaigns);

    }


}
