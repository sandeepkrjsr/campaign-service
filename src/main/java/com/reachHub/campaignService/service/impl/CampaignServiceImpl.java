package com.reachHub.campaignService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reachHub.campaignService.domain.entity.Campaign;
import com.reachHub.campaignService.repository.CampaignRepository;
import com.reachHub.campaignService.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService{
	
	private final CampaignRepository repository;
	
	CampaignServiceImpl(CampaignRepository repository){
		this.repository = repository;
	}

	@Override
	public Campaign createCampaign(Campaign campaign) {
		return repository.save(campaign);
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		return repository.findAll();
	}

}
