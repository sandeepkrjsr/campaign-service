package com.reachHub.campaignService.dto;

import com.reachHub.campaignService.domain.entity.Campaign;

import jakarta.validation.constraints.NotBlank;

public class CampaignRequest {
	
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Campaign toEntity() {
		Campaign campaign = new Campaign();
		campaign.setName(this.name);
		return campaign;
	}

}
