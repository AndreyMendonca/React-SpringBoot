package com.andrey.projeto.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrey.projeto.domain.entity.Client;
import com.andrey.projeto.domain.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client save(Client client) {
		return repository.save(client);
	}
	
	public List<Client> findAll(){
		return repository.findAll();
	}
}
