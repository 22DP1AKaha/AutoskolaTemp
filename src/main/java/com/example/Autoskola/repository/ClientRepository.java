package com.example.Autoskola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Autoskola.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username); 
    Client findByUsernameAndPassword(String username, String password); 
    Client findByIsActiveTrue();
}
