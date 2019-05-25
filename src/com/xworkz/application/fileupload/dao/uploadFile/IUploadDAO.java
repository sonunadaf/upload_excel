package com.xworkz.application.fileupload.dao.uploadFile;

import com.xworkz.application.fileupload.entity.uploadFile.UploadEntity;
import com.xworkz.application.fileupload.exception.DAOException;

public interface IUploadDAO {

	public Integer save(UploadEntity uploadEntity) throws DAOException;

}
