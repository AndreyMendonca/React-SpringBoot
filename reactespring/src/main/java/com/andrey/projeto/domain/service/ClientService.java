package com.andrey.projeto.domain.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Client> findById(Long id){
		return repository.findById(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Client update(Client client) {
		return repository.save(client);
	}
}
