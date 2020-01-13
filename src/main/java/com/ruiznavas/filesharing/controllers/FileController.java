package com.ruiznavas.filesharing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ruiznavas.filesharing.services.FileService;

@Controller
public class FileController {
	@Autowired
	FileService fileService;
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
		fileService.uploadFile(file);
		
		redirectAttributes.addFlashAttribute("message", "Fichero subido correctamente: " + file.getOriginalFilename() + "!");
		return "redirect:/";
	}
}	

