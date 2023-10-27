package com.wirecard.challenge.service;

import com.wirecard.challenge.dto.PaymentRequestDTO;
import com.wirecard.challenge.entity.Buyer;
import com.wirecard.challenge.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository repository;
    public Buyer getOrCreateBuyer(PaymentRequestDTO dto){
        return repository.findByCpf(dto.cpf())
                .orElseGet(() -> {
                    Buyer buyer = new Buyer();
                    buyer.setName(dto.name());
                    buyer.setCpf(dto.cpf());
                    buyer.setEmail(dto.email());

                    return repository.save(buyer);
                });
    }
}
