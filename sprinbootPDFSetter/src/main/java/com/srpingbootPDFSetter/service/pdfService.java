package com.srpingbootPDFSetter.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.srpingbootPDFSetter.dto.pdfBeanDTO;

@Service
public interface pdfService {

	public pdfBeanDTO pdfProcess(HttpHeaders responseHeader);
}
