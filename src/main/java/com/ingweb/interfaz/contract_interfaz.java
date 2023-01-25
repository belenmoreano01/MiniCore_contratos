package com.ingweb.interfaz;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingweb.model.contract;

@Repository

public interface contract_interfaz extends JpaRepository<contract, Integer> {

}