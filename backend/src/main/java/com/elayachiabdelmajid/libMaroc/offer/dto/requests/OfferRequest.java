package com.elayachiabdelmajid.libMaroc.offer.dto.requests;

import com.elayachiabdelmajid.libMaroc.offer.entity.SlugBooks;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest  {
    private String name;
    private String type;
    private SlugBooks slugs;
}
