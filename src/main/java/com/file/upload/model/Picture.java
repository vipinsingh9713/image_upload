package com.file.upload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;

@Entity
@Table(name = "picture_nir")
public class Picture {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    @Column(name = "file_name")
    private String name;

    public Picture() {
        super();
    }

    public Picture(int id  , String name) {
        this.id = id;
        
        this.name =  name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "Picture [id=" + id + ", name=" +"]";
    }
}
