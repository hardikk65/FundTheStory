package com.app.FundTheStory.Entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class campaignCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @OneToMany(mappedBy = "campaignCategory", cascade = CascadeType.ALL)
    private List<Campaign> campaigns = new ArrayList<>();

    public campaignCategory() {
        // Default constructor required by JPA
    }

    public campaignCategory(String category) {
        this.category = category;
    }

    public campaignCategory(String category, List<Campaign> campaigns) {
        this.category = category;
        this.campaigns = campaigns;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
