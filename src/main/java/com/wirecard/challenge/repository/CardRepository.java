package com.wirecard.challenge.repository;

import com.wirecard.challenge.entity.Buyer;
import com.wirecard.challenge.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByNumber(String number);

}
