package com.elayachiabdelmajid.libMaroc.offer.services;


import com.elayachiabdelmajid.libMaroc.offer.dto.requests.OfferRequest;
import com.elayachiabdelmajid.libMaroc.offer.dto.responses.OfferResponse;

public interface OfferService {

    OfferResponse findOfferById(Long offerId);

    void saveOffer(OfferRequest offerRequest);

    void updateOffer(OfferRequest offerRequest, Long offerId);

    void deleteOfferById(Long offerId);
}
