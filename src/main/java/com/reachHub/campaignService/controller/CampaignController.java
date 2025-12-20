package com.reachHub.campaignService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reachHub.campaignService.domain.entity.Campaign;
import com.reachHub.campaignService.dto.CampaignRequest;
import com.reachHub.campaignService.dto.CampaignResponse;
import com.reachHub.campaignService.service.CampaignService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {
	
	private final CampaignService service;
	
	CampaignController(CampaignService service){
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<CampaignResponse> createCampaign(@Valid @RequestBody CampaignRequest request) {
		Campaign campaign = service.createCampaign(request.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CampaignResponse.fromEntity(campaign));
	}
	
	@GetMapping
	public ResponseEntity<List<CampaignResponse>> getCampaigns() {
		List<Campaign> campaigns = service.getAllCampaigns();
		
		List<CampaignResponse> response = campaigns.stream()
				.filter(campaign -> campaign != null)
				.map(CampaignResponse::fromEntity)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	

}
