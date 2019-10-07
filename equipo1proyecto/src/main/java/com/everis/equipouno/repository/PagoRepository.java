package com.everis.equipouno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.equipouno.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{

}
