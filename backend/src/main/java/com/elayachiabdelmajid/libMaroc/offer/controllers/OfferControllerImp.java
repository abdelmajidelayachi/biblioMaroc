package com.elayachiabdelmajid.libMaroc.offer.controllers;

import com.elayachiabdelmajid.libMaroc.offer.dto.requests.OfferRequest;
import com.elayachiabdelmajid.libMaroc.offer.dto.responses.OfferResponse;
import com.elayachiabdelmajid.libMaroc.offer.services.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/offers")
public class OfferControllerImp implements OfferController{

    private final OfferService offerService;

    public OfferControllerImp(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("{offerId}")
    @Override
    public OfferResponse getOfferById(@PathVariable("offerId") Long offerId) {
        log.info("Offer id: {}", offerId);
        return offerService.findOfferById(offerId);
    }

    @PostMapping
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOffer(@RequestBody OfferRequest offerRequest) {
        offerService.saveOffer(offerRequest);
    }

    @PutMapping("{offerId}")
    @Override
    public void updateOffer(@RequestBody OfferRequest offerRequest, Long offerId) {
        offerService.updateOffer(offerRequest, offerId);
    }

    @DeleteMapping("{offerId}")
    @Override
    public void deleteOffer(Long offerId) {
        offerService.deleteOfferById(offerId);
    }
}
