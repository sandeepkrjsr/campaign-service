package com.reachHub.campaignService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reachHub.campaignService.domain.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
