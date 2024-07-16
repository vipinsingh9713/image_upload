package com.file.upload.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.dao.PictureRepository;
import com.file.upload.model.Picture;

@Service
public class PictureServiceImpl implements PictureService{
	
	
	 private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);


	@Value("${upload.directory}")
	private String uploadDirectory;
	
	@Autowired
	private PictureRepository pictureRepository;
	
	@Override
	public List<Picture> getAllPicture() {
		return this.pictureRepository.findAll();
	}

	@Override
	public void savePicture(Picture picture , MultipartFile file) throws Exception {
		
		
		
		if(file.isEmpty())
		{
			System.out.println("file is empty");
		}
		
		Path uplaodPath = Paths.get(uploadDirectory).toAbsolutePath().normalize();
		
		if(!Files.exists(uplaodPath))
		{
			logger.info("Upload directory does not exist. Creating directory: {}", uplaodPath);
			System.out.println(uplaodPath);
			Files.createDirectories(uplaodPath);
		}
		
		String OriginalFilename = file.getOriginalFilename();
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String newFile = timeStamp + "_"+OriginalFilename;
		Path filePath = uplaodPath.resolve(newFile);
		
		Files.write(filePath , file.getBytes());
		picture.setName(newFile);
		
		pictureRepository.save(picture);
		
	}

}
