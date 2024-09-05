package com.example.contactsmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.contactsmanager.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
	Optional<Contact> findById(String id);
}
