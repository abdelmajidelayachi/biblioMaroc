package com.abdelmajidelayachi.libmaroc.offer.dto.responses;

import com.abdelmajidelayachi.libmaroc.offer.entity.SlugBooks;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {

    private Long id;

    private String name;
    private String type;
    private SlugBooks slugs;
    private String createdAt;
    private String updatedAt;
}
