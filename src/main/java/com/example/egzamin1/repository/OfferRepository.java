package com.example.egzamin1.repository;

import com.example.egzamin1.Service;
import com.example.egzamin1.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
