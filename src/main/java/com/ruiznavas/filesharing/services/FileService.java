package com.ruiznavas.filesharing.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ruiznavas.filesharing.exceptions.FileSharingException;

@Service
public class FileService {
	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;
	
	public void uploadFile(MultipartFile file) {
		try {
			Path copyLocation = Paths.get(uploadDir + StringUtils.cleanPath(file.getOriginalFilename()));
			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			e.printStackTrace();
			throw new FileSharingException("Imposible almacenar el fichero: " + file.getOriginalFilename() + ". Intentelo de nuevo.");
		}
	}
}
