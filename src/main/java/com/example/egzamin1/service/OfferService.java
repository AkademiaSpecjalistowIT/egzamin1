package com.example.egzamin1.service;

import com.example.egzamin1.dto.OfferDto;
import com.example.egzamin1.dto.OfferInput;
import java.util.List;

public interface OfferService {

    void createOffer(OfferInput offerInput);

    List<OfferDto> getOffers();
}
