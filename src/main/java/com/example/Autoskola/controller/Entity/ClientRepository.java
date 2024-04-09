package com.example.Autoskola.controller.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUsername(String username); 
    Client findByUsernameAndPassword(String username, String password); 
}
