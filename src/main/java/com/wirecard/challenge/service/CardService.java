package com.wirecard.challenge.service;

import com.wirecard.challenge.dto.CardDTO;
import com.wirecard.challenge.entity.Buyer;
import com.wirecard.challenge.entity.Card;
import com.wirecard.challenge.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;

    public Card getOrCreateCard(CardDTO dto, Buyer buyer) {
        return repository.findByNumber(dto.number())
                .orElseGet(() -> {
                    Card card = new Card();
                    card.setBuyer(buyer);
                    card.setHolderName(dto.holderName());
                    card.setNumber(dto.number());
                    card.setExpirationDate(dto.expirationDate());
                    card.setCvv(dto.cvv());
                    card.setIssuer(dto.issuer());

                    return repository.save(card);
                });
    }
}