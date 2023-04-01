package com.abdelmajidelayachi.libmaroc.offer.dto.mapper;

import com.abdelmajidelayachi.libmaroc.offer.dto.requests.OfferRequest;
import com.abdelmajidelayachi.libmaroc.offer.dto.responses.OfferResponse;
import com.abdelmajidelayachi.libmaroc.offer.entity.Offer;
import com.abdelmajidelayachi.libmaroc.utils.mapper.EntityDtoMapper;

import java.util.List;

public class OfferMapper {

    public static List<OfferResponse> mapOfferEntityListToDtoResponseList(List<Offer> offerList){
        return offerList.stream().map(OfferMapper::mapOfferEntityToDtoOfferResponse).toList();
    }

    public static OfferResponse mapOfferEntityToDtoOfferResponse(Offer offer){
        return EntityDtoMapper.toDto(offer, OfferResponse.class);
    }

    public static Offer mapOfferRequestDtoToOfferEntity(OfferRequest offerRequest){
        return EntityDtoMapper.toEntity(offerRequest, Offer.class);
    }
}
