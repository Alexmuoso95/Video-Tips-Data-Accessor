package com.data.accessor.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.accessor.controller.definition.ClientController;
import com.data.accessor.entity.Client;
import com.data.accessor.service.definition.ClientService;

@RestController
@RequestMapping("v1/clients")
public class ClientControllerImpl implements ClientController {

	@Autowired
	ClientService service;

	public ResponseEntity<List<Client>> getCLients() {
		return new ResponseEntity<>(service.getClients(), HttpStatus.OK);
	}

	public ResponseEntity<Client> createClient(Client client) {
		return new ResponseEntity<>(service.createClient(client), HttpStatus.CREATED);
	}

	public ResponseEntity<Client> getClientById(Long id) {
		return new ResponseEntity<>(service.getClientById(id), HttpStatus.OK);
	}

	public ResponseEntity<Client> getClientByName(String name,@RequestParam String lastName) {
		return new ResponseEntity<>(service.getClientByName(name,lastName), HttpStatus.OK);
	}

	public ResponseEntity<Client> updateClient(Client client) {
		return new ResponseEntity<>(service.updateClient(client), HttpStatus.OK);
	}

	public ResponseEntity<?> deleteClient(Long id) {
		return new ResponseEntity<>(service.deleteClient(id), HttpStatus.OK);
	}

}
