package com.xworkz.application.fileupload.service.uploadFile;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.application.fileupload.exception.ServiceException;

public interface IUploadService {

	public void uploadFile(MultipartFile fileBean) throws ServiceException;

}
