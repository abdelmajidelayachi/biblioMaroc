package com.abdelmajidelayachi.libmaroc.offer.repository;

import com.abdelmajidelayachi.libmaroc.offer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    //
}
