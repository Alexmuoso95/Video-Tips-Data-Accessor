package com.data.accessor.repository.daohibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.data.accessor.entity.Client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	public EntityManager entityManger;
	//JDB OR Hibernate , performance, easy way .
	//Query
	//TypeQuery
	//NamedQuery
	//NativeQuery
	//CriteriaQuery
	
	@SuppressWarnings("unchecked")
	@Override
	public 	List<Client> getClients() {
		//Query
		Query query = null ;
		try { query = entityManger.createNamedQuery("client_find_all", Client.class);} catch (Exception e) {
		}finally {
			entityManger.close();
		}
		return query.getResultList();
	}
	@Override
	public Client getClientById(Long id) {
		return entityManger.find(Client.class,id);
	}
	@Override
	public Client getClientByName(String name,String lastName) {
		TypedQuery<Client> query = null;
		try {
			query= entityManger.createQuery("SELECT c FROM client c WHERE c.name = :name AND c.lastName = :last_name",Client.class);
			query.setParameter("name",name);
			query.setParameter("last_name",lastName);
			return query.getSingleResult();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}
	@Override
	public Client createClient(Client client) {
		try {
			entityManger.persist(client);
		}catch (Exception e) {
			//
		}finally {
			entityManger.close();
		}
		return client;
	}

	@Override
	public Client updateClient(Client client) {
		try {
			//UPDATE
			entityManger.joinTransaction();
			entityManger.merge(client);
			entityManger.flush();
			/*entityManger.clear();*/
			//GET
			CriteriaBuilder criteriaBuilder = entityManger.getCriteriaBuilder();
			CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
			Root<Client> root = criteriaQuery.from(Client.class);
			ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
			Predicate idPredicate = criteriaBuilder.equal(root.get("id"), idParam);
			criteriaQuery.select(root).where(criteriaBuilder.and(idPredicate));
			TypedQuery<Client> query = entityManger.createQuery(criteriaQuery);
			query.setParameter(idParam, client.getId());
			return query.getSingleResult();
		}catch (Exception e) {
			log.info(e.getMessage());
		}finally {
			entityManger.close();
		}
		return null;
	}

	@Override
	public String deleteClient(Long id) {
		entityManger.remove(entityManger.find(Client.class,id));
		return "DELETED";
	}

}
