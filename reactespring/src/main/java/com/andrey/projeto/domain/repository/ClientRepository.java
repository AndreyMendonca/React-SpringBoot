package com.andrey.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrey.projeto.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
