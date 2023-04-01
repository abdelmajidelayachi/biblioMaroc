package com.abdelmajidelayachi.libmaroc.offer.controllers;

import com.abdelmajidelayachi.libmaroc.offer.dto.requests.OfferRequest;
import com.abdelmajidelayachi.libmaroc.offer.dto.responses.OfferResponse;


public interface OfferController {


    OfferResponse getOfferById(Long offerId);

    void saveOffer(OfferRequest offerRequest);

    void updateOffer(OfferRequest  offerRequest, Long offerId);

    void deleteOffer(Long offerId);
}
