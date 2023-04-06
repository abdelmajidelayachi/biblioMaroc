package com.abdelmajidelayachi.libmaroc.offer.dto.requests;

import com.abdelmajidelayachi.libmaroc.offer.entity.SlugBooks;
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
