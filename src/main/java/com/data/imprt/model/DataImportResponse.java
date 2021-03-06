package com.data.imprt.model;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataImportResponse {

	private String status;
	private String message;
	
	private Map<String, Object> details;
}
