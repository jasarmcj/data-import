package com.data.imprt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.data.imprt.model.DataImportResponse;
import com.data.imprt.service.DataImportService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jasar
 *
 */
@Slf4j
@RestController
@RequestMapping("/") 
public class DataImportController {

	@Autowired
	private DataImportService dataImportService; 

	@PostMapping
	public DataImportResponse importData(@RequestParam("file") MultipartFile fileUpload) {

		log.info("Request received to import book data into database");
		DataImportResponse response =  dataImportService.importData(fileUpload);
		
		log.info("Request processing completed");
		return response;
	}
}
