package com.srpingbootPDFSetter.dto;

import java.io.File;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class pdfSetter {

	@JsonProperty("File")
	private File pdfFile;
	public File getPdfFile() {
		return pdfFile;
	}
	public void setPdfFile(File pdfFile) {
		this.pdfFile = pdfFile;
	}
	
}
