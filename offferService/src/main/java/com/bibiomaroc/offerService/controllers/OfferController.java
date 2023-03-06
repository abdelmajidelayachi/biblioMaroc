package com.bibiomaroc.offerService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {

    @GetMapping
    String getOffers(){
        return "<h1>Hello this application is working!!!!!!!!!!!!!!!!!!!!</h1>";

    }
}
