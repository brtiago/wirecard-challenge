package com.wirecard.challenge.entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Buyer buyer;
    private String holderName;
    private String number;
    private String expirationDate;
    private String cvv;
    private String issuer;
}
