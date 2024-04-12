package com.example.Autoskola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Autoskola.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}