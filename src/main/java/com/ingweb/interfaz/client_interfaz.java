package com.ingweb.interfaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingweb.model.client;

@Repository

public interface client_interfaz extends JpaRepository<client, Integer>{

}