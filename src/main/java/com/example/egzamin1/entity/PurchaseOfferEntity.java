package com.example.egzamin1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PurchaseOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String offerContent;

    public PurchaseOfferEntity(String value) {
        if (value.length() > 10) {
            throw new RuntimeException("Offer length is too long");
        }
        this.offerContent = value;
    }
}
