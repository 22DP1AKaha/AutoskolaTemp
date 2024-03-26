package com.example.Autoskola.controller.Entity;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository<I> extends CrudRepository<Client, Long> {

// save
// findOne
// exists
// findAll
// count
// delete
// deleteAll
    Client findByUsername(String username);

}
