package com.reachHub.campaignService.service;

import java.util.List;

import com.reachHub.campaignService.domain.entity.Campaign;

public interface CampaignService {

	public Campaign createCampaign(Campaign campaign);

	public List<Campaign> getAllCampaigns();

}
