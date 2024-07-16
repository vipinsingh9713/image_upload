package com.file.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.model.Picture;
import com.file.upload.service.PictureService;

@Controller
public class HomeController {

	@Autowired
	private PictureService pictureService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("listOfPicture",pictureService.getAllPicture());
		return "home";
	}
	
	@GetMapping("/uplaod-form")
	public String showUploadForm(Model model)
	{
		model.addAttribute("picture",new Picture());
		return "upload_form";
	}
	
	 @PostMapping("/upload")
	    public String uploadFile(@ModelAttribute("picture") Picture picture, @RequestParam("file") MultipartFile file) throws Exception {
		 
		 this.pictureService.savePicture(picture,file);
		 
		 return "redirect:/";
		
	    }
}
