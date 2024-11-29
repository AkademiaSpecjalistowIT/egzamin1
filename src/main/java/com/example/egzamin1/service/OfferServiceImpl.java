package com.example.egzamin1.service;

import com.example.egzamin1.dto.OfferDto;
import com.example.egzamin1.entity.OfferEntity;
import com.example.egzamin1.repository.OfferRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Override
    public void createOffer(OfferDto offerDto) {
        offerRepository.save(new OfferEntity(offerDto.value()));
    }

    @Override
    public List<OfferDto> getOffers() {
        return offerRepository.findAll()
            .stream()
            .map(e -> new OfferDto(e.getValue()))
            .toList();
    }
}
