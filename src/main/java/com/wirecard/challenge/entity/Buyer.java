package com.wirecard.challenge.entity;

import com.wirecard.challenge.dto.PaymentRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity(name = "buyers")
@Table(name = "buyers")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email
    private String email;
    @Column(unique = true)
    private String cpf;

    public Buyer(PaymentRequestDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.cpf = dto.cpf();
    }

}
