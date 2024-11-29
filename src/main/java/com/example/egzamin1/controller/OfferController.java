package com.example.egzamin1.controller;

import com.example.egzamin1.dto.OfferDto;
import com.example.egzamin1.dto.OfferInput;
import com.example.egzamin1.service.OfferService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public List<OfferDto> getOffers() {
        return offerService.getOffers();
    }

    @PostMapping
    public void createOffer(@RequestBody OfferInput offerInput) {
        offerService.createOffer(offerInput);
    }
}
