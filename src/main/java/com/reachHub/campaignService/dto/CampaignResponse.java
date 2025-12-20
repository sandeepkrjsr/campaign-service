package com.reachHub.campaignService.dto;

import com.reachHub.campaignService.domain.entity.Campaign;

public class CampaignResponse {
	
	private String name;

	CampaignResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static CampaignResponse fromEntity(Campaign campaign) {
		if(campaign == null)
			return null;
		return new CampaignResponse(campaign.getName());
	}

}
