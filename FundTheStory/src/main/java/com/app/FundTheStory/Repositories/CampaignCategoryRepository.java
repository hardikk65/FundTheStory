package com.app.FundTheStory.Repositories;

import com.app.FundTheStory.Entities.CampaignCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignCategoryRepository extends JpaRepository<CampaignCategory,Long> {
}
