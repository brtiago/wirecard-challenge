package com.wirecard.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "clients")
@Table(name = "clients")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
