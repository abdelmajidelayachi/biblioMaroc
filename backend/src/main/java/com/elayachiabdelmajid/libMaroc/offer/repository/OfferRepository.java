package com.elayachiabdelmajid.libMaroc.offer.repository;


import com.elayachiabdelmajid.libMaroc.offer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    //
}
