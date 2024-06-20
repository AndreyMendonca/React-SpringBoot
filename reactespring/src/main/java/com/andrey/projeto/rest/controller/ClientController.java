package com.andrey.projeto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.andrey.projeto.domain.entity.Client;
import com.andrey.projeto.domain.service.ClientService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody @Valid Client client) {
		return service.save(client);
	}
	
	@GetMapping
	public List<Client> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não localizado"));
		
		service.delete(id);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		return service.findById(id)
				.map( obj ->{
					client.setId(obj.getId());
					return service.update(client);
				}
				).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	
	
}
