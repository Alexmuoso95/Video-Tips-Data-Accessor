package com.data.accessor.repository.jpahibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.accessor.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
