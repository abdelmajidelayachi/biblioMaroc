package com.abdelmajidelayachi.libmaroc.offer.services;

import com.abdelmajidelayachi.libmaroc.offer.dto.requests.OfferRequest;
import com.abdelmajidelayachi.libmaroc.offer.dto.responses.OfferResponse;


public interface OfferService {

    OfferResponse findOfferById(Long offerId);

    void saveOffer(OfferRequest offerRequest);

    void updateOffer(OfferRequest offerRequest, Long offerId);

    void deleteOfferById(Long offerId);
}
