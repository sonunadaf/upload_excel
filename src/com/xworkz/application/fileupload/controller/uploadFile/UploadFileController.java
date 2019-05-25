package com.xworkz.application.fileupload.controller.uploadFile;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.application.fileupload.constants.PageEnum;
import com.xworkz.application.fileupload.exception.ControllerException;
import com.xworkz.application.fileupload.exception.ServiceException;
import com.xworkz.application.fileupload.service.uploadFile.IUploadService;

@Controller
@RequestMapping("/")
public class UploadFileController {

	@Autowired
	private IUploadService uploadService;

	public UploadFileController() {
	}

	@RequestMapping(value = "/onupload", method = RequestMethod.GET)
	public String onUploadFile() {
		return PageEnum.UploadFile.toString();
	}

	@RequestMapping(value = "/onupload", method = RequestMethod.POST)
	public String onUploadFile(@RequestParam("xmlFile") MultipartFile file, Model model)
			throws IOException, ControllerException {
		try {
			if (file.getOriginalFilename().endsWith("xls") || file.getOriginalFilename().endsWith("xlsx")) {
				uploadService.uploadFile(file);
			} else {
				model.addAttribute("message", "Upload Excel file formate");
			}
		} catch (ServiceException e) {
			System.err.println("Exception from Controller " + e.getMessage());
			throw new ControllerException(e.getMessage());
		}
		return PageEnum.UploadFile.toString();

	}
}
