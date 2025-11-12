package com.retail.rewards.controller;

import com.retail.rewards.dto.RewardsResponseDTO;
import com.retail.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/transactions")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/rewards/{customerId}")
    public ResponseEntity<?> getRewards(@PathVariable String customerId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate , @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) throws Exception {
        LocalDate today = LocalDate.now();
        if(fromDate!=null && toDate!=null && fromDate.isAfter(toDate))
            throw new IllegalArgumentException("From Date cannot be after to Date...");
        if(fromDate!=null && toDate!=null && (fromDate.isBefore(today.minusDays(90)) || toDate.isAfter(today)))
            throw new IllegalArgumentException("Date range cannot exceed last 90 days or be in the future..");
        RewardsResponseDTO rewards = rewardService.getRewards(customerId,fromDate,toDate);
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }
}
