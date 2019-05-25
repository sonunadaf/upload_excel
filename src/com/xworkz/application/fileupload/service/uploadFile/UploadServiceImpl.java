package com.xworkz.application.fileupload.service.uploadFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.application.fileupload.dao.uploadFile.IUploadDAO;
import com.xworkz.application.fileupload.entity.uploadFile.UploadEntity;
import com.xworkz.application.fileupload.exception.DAOException;
import com.xworkz.application.fileupload.exception.ServiceException;

@Service
public class UploadServiceImpl implements IUploadService {

	@Autowired
	private IUploadDAO iUploadDAO;

	public UploadServiceImpl() {
	}
	@Override
	public void uploadFile(MultipartFile fileBean) throws ServiceException {
		ByteArrayInputStream bis = null;
		Sheet sheet = null;
		try {
			bis = new ByteArrayInputStream(fileBean.getBytes());
			Workbook workbook;
			if (fileBean.getOriginalFilename().endsWith("xls")) {
				workbook = new HSSFWorkbook(bis);
				sheet = workbook.getSheetAt(0);
			} else if (fileBean.getOriginalFilename().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(bis);
				sheet = workbook.getSheetAt(0);
			}
			for (Row row : sheet) {
				int index = 1;
				Map<Integer, Object> map = new HashedMap<Integer, Object>();
				if (row.getRowNum() != 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getCellType() == CellType.NUMERIC) {
							double db = cell.getNumericCellValue();
							map.put(index, db);
						}
						if (cell.getCellType() == CellType.STRING) {
							String st = cell.getStringCellValue();
							map.put(index, st);
						}

						index++;
					}
					UploadEntity uploadEntity = new UploadEntity();
					uploadEntity.setPartyId((Double) map.get(1));
					uploadEntity.setPartyName((String) map.get(2));
					uploadEntity.setWon((Double) map.get(3));
					uploadEntity.setLost((Double) map.get(4));
					uploadEntity.setState((String) map.get(5));
					iUploadDAO.save(uploadEntity);
				}
			}
		} catch (IOException e) {
			System.err.println("Exception From Service" + e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (DAOException e) {
			System.err.println("Exception From Service" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}

	}

}
