package com.elayachiabdelmajid.libMaroc.offer.controllers;


import com.elayachiabdelmajid.libMaroc.offer.dto.requests.OfferRequest;
import com.elayachiabdelmajid.libMaroc.offer.dto.responses.OfferResponse;

public interface OfferController {


    OfferResponse getOfferById(Long offerId);

    void saveOffer(OfferRequest offerRequest);

    void updateOffer(OfferRequest offerRequest, Long offerId);

    void deleteOffer(Long offerId);
}
