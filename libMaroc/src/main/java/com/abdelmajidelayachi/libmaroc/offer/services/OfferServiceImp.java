package com.abdelmajidelayachi.libmaroc.offer.services;

import com.abdelmajidelayachi.libmaroc.offer.dto.mapper.OfferMapper;
import com.abdelmajidelayachi.libmaroc.offer.dto.requests.OfferRequest;
import com.abdelmajidelayachi.libmaroc.offer.dto.responses.OfferResponse;
import com.abdelmajidelayachi.libmaroc.offer.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImp implements OfferService{

    private final OfferRepository offerRepository;

    public OfferServiceImp(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public OfferResponse findOfferById(Long offerId) {
        return OfferMapper.mapOfferEntityToDtoOfferResponse(offerRepository.findById(offerId).orElseThrow(()-> new RuntimeException("Offer not found")));
    }

    @Override
    public void saveOffer(OfferRequest offerRequest) {
        offerRepository.save(OfferMapper.mapOfferRequestDtoToOfferEntity(offerRequest));
    }

    @Override
    public void updateOffer(OfferRequest offerRequest, Long offerId) {

    }

    @Override
    public void deleteOfferById(Long offerId) {

    }
}
