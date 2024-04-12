package com.example.Autoskola.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Autoskola.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUsername(String username); 
    Client findByUsernameAndPassword(String username, String password); 
}
