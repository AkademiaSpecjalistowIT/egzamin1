package com.example.egzamin1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.egzamin1.dto.OfferInput;
import com.example.egzamin1.entity.UserEntity;
import com.example.egzamin1.repository.OfferRepository;
import com.example.egzamin1.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OfferServiceImplTest {

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        offerRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void user_should_not_be_created_if_making_offer_failed() {
        //given
        OfferInput offer = new OfferInput("14812342342347398", "adam");

        //when
        Executable e = () -> offerService.createOffer(offer);

        //then
        assertThrows(RuntimeException.class, e);
        assertThat(offerRepository.findAll()).hasSize(0);
        assertThat(userRepository.findAll()).hasSize(0);
    }

    @Test
    void should_create_an_offer_for_existing_user() {
        //given
        UserEntity testUser = userRepository.save(new UserEntity("testUser"));
        OfferInput offerInput = new OfferInput("123", testUser.getName());

        //when
        offerService.createOffer(offerInput);

        //then
        assertThat(offerRepository.findAll()).hasSize(1);
    }


}