package com.example.springbootfileuploadrestapi.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbootfileuploadrestapi.exception.FileStorageException;
import com.example.springbootfileuploadrestapi.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(String path, MultipartFile file) {
		// file name
		String filename = file.getOriginalFilename();
		
		// full path
		String filepath_With_name = path + File.separator + filename;
		
		Path targetLocation = Paths.get(filepath_With_name);
		
		File f = new File(path);
		
		if (!f.exists()) {
			f.mkdir();
		}
		
		try {
			// Check if file already exists
            if (Files.exists(targetLocation)) {
                throw new FileStorageException("File already exists: " + targetLocation.toString());
            }
			
			Files.copy(file.getInputStream(), targetLocation);
		} catch (IOException e) {
			 System.out.println("File copying error *");
			 throw new FileStorageException("File copying/uploading error", e);
		}
		
		return filename;
	}
	
}
