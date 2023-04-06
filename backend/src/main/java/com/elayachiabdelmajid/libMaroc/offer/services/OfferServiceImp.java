package com.elayachiabdelmajid.libMaroc.offer.services;

import com.elayachiabdelmajid.libMaroc.offer.dto.requests.OfferRequest;
import com.elayachiabdelmajid.libMaroc.offer.dto.responses.OfferResponse;
import com.elayachiabdelmajid.libMaroc.offer.entity.Offer;
import com.elayachiabdelmajid.libMaroc.offer.repository.OfferRepository;
import com.elayachiabdelmajid.libMaroc.utils.mapper.EntityDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImp implements OfferService{

    private final OfferRepository offerRepository;

    public OfferServiceImp(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public OfferResponse findOfferById(Long offerId) {
        return EntityDtoMapper.toDto(offerRepository.findById(offerId).orElseThrow(()-> new RuntimeException("Offer not found")), OfferResponse.class);
    }

    @Override
    public void saveOffer(OfferRequest offerRequest) {
        Offer offer = EntityDtoMapper.toEntity(offerRequest, Offer.class);
        offerRepository.save(offer);
    }

    @Override
    public void updateOffer(OfferRequest offerRequest, Long offerId) {

    }

    @Override
    public void deleteOfferById(Long offerId) {

    }
}
