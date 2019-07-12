package com.srpingbootPDFdemo.service;

import org.springframework.stereotype.Service;

import com.srpingbootPDFdemo.dto.pdfBeanDTO;
import com.srpingbootPDFdemo.dto.pdfSetter;

@Service
public interface PdfProcessService {

	public pdfBeanDTO processPdf(pdfSetter pdffileSetter);
}
