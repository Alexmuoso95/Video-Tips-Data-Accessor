package com.data.accessor.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.accessor.entity.Client;
import com.data.accessor.repository.daohibernate.ClientDao;
import com.data.accessor.service.definition.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDao repo;
	
	@Override
	public List<Client> getClients() {
		return repo.getClients();
	}

	@Override
	public Client getClientById(Long id) {
		return repo.getClientById(id);
	}
	@Override
	public Client getClientByName(String name,String lastName) {
		return repo.getClientByName(name,lastName);
	}
	@Override
	public Client createClient(Client client) {
		return repo.createClient(client);
	}

	@Override
	public Client updateClient(Client client) {
		return repo.updateClient(client);
	}

	@Override
	public String deleteClient(Long id) {
		return repo.deleteClient(id);
	}

	
}
