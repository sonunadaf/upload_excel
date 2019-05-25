package com.xworkz.application.fileupload.dto.uploadFile;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile fileData;

	public FileBean() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

}
