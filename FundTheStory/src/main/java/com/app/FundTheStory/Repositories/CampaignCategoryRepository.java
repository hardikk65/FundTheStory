package com.app.FundTheStory.Repositories;

import com.app.FundTheStory.Entities.campaignCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignCategoryRepository extends JpaRepository<campaignCategory,Long> {

}
