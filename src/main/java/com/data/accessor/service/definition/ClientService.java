package com.data.accessor.service.definition;

import java.util.List;

import com.data.accessor.entity.Client;

public interface ClientService {
	List<Client> getClients();
	Client getClientById(Long id);
	Client getClientByName(String name,String lastName);
	Client createClient(Client client);
	Client updateClient(Client client);
	String deleteClient(Long id);
}
