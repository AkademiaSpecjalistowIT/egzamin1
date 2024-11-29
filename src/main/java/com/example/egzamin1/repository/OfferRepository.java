package com.example.egzamin1.repository;

import com.example.egzamin1.entity.PurchaseOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<PurchaseOfferEntity, Long> {
}
