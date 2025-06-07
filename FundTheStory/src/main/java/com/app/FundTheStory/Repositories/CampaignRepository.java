package com.app.FundTheStory.Repositories;


import com.app.FundTheStory.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {

    List<Campaign> findByCampaignCategory_Id(Long id);

    List<Campaign> findByGoalAmountBetween(double minAmount,double maxAmount);
}
