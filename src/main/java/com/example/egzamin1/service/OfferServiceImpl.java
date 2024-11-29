package com.example.egzamin1.service;

import com.example.egzamin1.dto.OfferDto;
import com.example.egzamin1.dto.OfferInput;
import com.example.egzamin1.entity.PurchaseOfferEntity;
import com.example.egzamin1.entity.UserEntity;
import com.example.egzamin1.repository.OfferRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;

    @Override
    public void createOffer(OfferInput offerInput) {
        findOrCreateUser(offerInput.userName());
        offerRepository.save(new PurchaseOfferEntity(offerInput.offerValue()));
    }

    private UserEntity findOrCreateUser(String userName) {
        return userService.findUserByName(userName)
            .orElseGet(() -> userService.createUser(userName));
    }

    @Override
    public List<OfferDto> getOffers() {
        return offerRepository.findAll()
            .stream()
            .map(e -> new OfferDto(e.getOfferContent()))
            .toList();
    }
}
