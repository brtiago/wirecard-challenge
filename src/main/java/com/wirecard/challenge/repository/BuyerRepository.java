package com.wirecard.challenge.repository;

import com.wirecard.challenge.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Optional<Buyer> findByCpf(String cpf);
    Optional<Buyer> findById(Long id);
}
