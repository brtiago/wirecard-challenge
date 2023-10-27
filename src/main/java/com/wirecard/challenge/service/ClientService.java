package com.wirecard.challenge.service;

import com.wirecard.challenge.dto.PaymentRequestDTO;
import com.wirecard.challenge.entity.Client;
import com.wirecard.challenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Client getOrCreateClient(PaymentRequestDTO dto){
        return repository.findClientById(dto.idClient())
                .orElseGet(() -> {
                   Client client = new Client();
                   return repository.save(client);
                });
    }
}
