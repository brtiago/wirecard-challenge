package com.wirecard.challenge.service;

import com.wirecard.challenge.dto.PaymentRequestDTO;
import com.wirecard.challenge.entity.*;
import com.wirecard.challenge.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private CardService cardService;

    public Payment createPayment(@RequestBody PaymentRequestDTO dto) throws Exception {
        Payment payment = new Payment(dto);

        payment.setClient(clientService.getOrCreateClient(dto));

        var buyer = buyerService.getOrCreateBuyer(dto);
        payment.setBuyer(buyer);

        if (dto.type() == PaymentMethod.BOLETO) {
            payment.setBoleto(createBoletoPayment());
        } else if (dto.type() == PaymentMethod.CARD) {
            payment.setCard(cardService.getOrCreateCard(dto.card(), buyer));
            payment.setStatus(PaymentStatus.APPROVED);
        }
        payment.setAmount(dto.amount());
        payment.setType(dto.type());

        System.out.println(payment.getType());

        return savePayment(payment);
    }

    private String createBoletoPayment() throws Exception{
        StringBuilder randomNumbers = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 48; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.append(randomNumber);
        }
        String randomNumbersString = randomNumbers.toString();

        return randomNumbersString;
    }

    private Payment savePayment(Payment payment){
        return this.repository.save(payment);
    }

    public List<Payment> listAll() {
        return repository.findAll();
    }
}
