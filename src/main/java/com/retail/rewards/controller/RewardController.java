package com.retail.rewards.controller;

import com.retail.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/transactions")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/rewards/{customerId}")
    public String getRewards(@PathVariable(required = false) Long customerId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate , @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate) throws Exception {
        rewardService.getRewards(customerId,toDate,fromDate);
        return "";
    }
}
