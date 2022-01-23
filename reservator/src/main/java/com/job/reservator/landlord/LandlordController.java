package com.job.reservator.landlord;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LandlordController {

    LandlordService landlordService;

    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @GetMapping("/time")
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    @GetMapping("/landlords")
    public List<Landlord> getAllLandlords() {
        return landlordService.getAllLandlords();
    }

}
