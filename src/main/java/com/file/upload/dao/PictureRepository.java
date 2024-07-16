package com.file.upload.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.upload.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
