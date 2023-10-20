package com.wirecard.challenge.entity;

import com.wirecard.challenge.dto.CreatePaymentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "payments")
@Table(name = "payments")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentMethod type;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus status;
    private String boleto;
    @ManyToOne
    private Card card;

    public Payment(CreatePaymentDTO dto) {
        this.client = new Client(dto.idClient());
        Buyer buyer = new Buyer();
        this.buyer = buyer;
        this.amount = dto.amount();
        this.type = dto.type();
        this.dateTime = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
        Card card = new Card();
        this.card = card;
    }

}
