package com.example.egzamin1.service;

import com.example.egzamin1.dto.OfferDto;
import java.util.List;

public interface OfferService {

    void createOffer(OfferDto offerDto);

    List<OfferDto> getOffers();
}
