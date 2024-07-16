package com.file.upload.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.file.upload.model.Picture;

public interface PictureService {

	public List<Picture> getAllPicture();
	public void savePicture (Picture picture , MultipartFile file) throws Exception;
}
