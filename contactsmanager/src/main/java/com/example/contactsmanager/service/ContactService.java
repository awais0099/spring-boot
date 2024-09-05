package com.example.contactsmanager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.contactsmanager.constant.Constant;
import com.example.contactsmanager.entities.Contact;
import com.example.contactsmanager.repositories.ContactRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ContactService {
	@Autowired
	private final ContactRepository contactRepository;
	
	public Contact getContact(String id) {
		return this.contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
	}
	
	public Contact createContact(Contact contact) {
		return this.contactRepository.save(contact);
	}
	
	public void deleteContact(Contact contact) {
		
	}
	
	public String uploadFile(String id, MultipartFile file) {
		log.info("uploadFile");
		Contact contact = getContact(id);
		String photoUrl = photoFunction(id, file);
		contact.setPhotoUrl(photoUrl);
		this.contactRepository.save(contact);
		return photoUrl;
	}
	
	private final String photoFunction(String id, MultipartFile image) {
		log.info("photoFunction");
		try {
			Path fileStorageLocation = Paths.get(Constant.PHOTO_DIRECTORY).toAbsolutePath().normalize();
			if (!Files.exists(fileStorageLocation)) {
				Files.createDirectories(fileStorageLocation);
			}
			
			Files.copy(
				image.getInputStream(), 
				fileStorageLocation.resolve(id + ".png"),
				StandardCopyOption.REPLACE_EXISTING
			);
			
			return ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/contacts/image/" + id + ".png")
					.toUriString();
		} catch (Exception e) {
			throw new RuntimeException("Unable to save image");
		}
	}
	
}







