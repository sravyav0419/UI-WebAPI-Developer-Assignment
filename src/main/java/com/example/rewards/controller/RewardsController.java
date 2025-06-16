package com.example.rewards.controller;

import com.example.rewards.model.RewardsResponse;
import com.example.rewards.service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping
    public List<RewardsResponse> getAllCustomerRewards() {
        return rewardsService.calculateRewards();
    }
}
