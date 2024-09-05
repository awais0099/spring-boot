package com.example.contactsmanager.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_DEFAULT)
public class Contact {
	@Id
	@Column(name = "id", unique = true, updatable = false)
	private String id;
	private String name;
	private String email;
	private String title;
	private String phone;
	private String address;
	private String status;
	private String photoUrl;
	
}
