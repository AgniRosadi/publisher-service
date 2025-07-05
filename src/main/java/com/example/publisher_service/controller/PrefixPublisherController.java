package com.example.publisher_service.controller;

import com.api.common.dto.PrefixDataReq;
import com.example.publisher_service.service.PrefixPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bo")
public class PrefixPublisherController {

    @Autowired
    private PrefixPublishService prefixPublisherService;

    @PostMapping("/add")
    public String publishAdd(@RequestBody PrefixDataReq req) {
        prefixPublisherService.publishAdd(req);
        return "Add Prefix Published";
    }

    @PostMapping("/update")
    public String publishUpdate(@RequestBody PrefixDataReq req) {
        prefixPublisherService.publishUpdate(req);
        return "Update Prefix Published";
    }
}
