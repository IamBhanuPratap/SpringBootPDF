package com.srpingbootPDFdemo.controller;

import java.util.Base64;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srpingbootPDFdemo.dto.pdfBeanDTO;
import com.srpingbootPDFdemo.dto.pdfSetter;
import com.srpingbootPDFdemo.service.PdfProcessService;
/*
 * 1 Takes pdf files and process
 * 2 Generates oauth token
 * 3 implements aspects
 * 4 use java 8
 * 5 Set headers and return
 * 6 Implement rest template*/
@RestController
@RequestMapping("/")
public class PDFDemoController {

	@Autowired
	public PdfProcessService pdfProcess;
	@Autowired
	public pdfBeanDTO pdfBean;
	@RequestMapping(path="/{processPDF}",produces=MediaType.APPLICATION_JSON,consumes=MediaType.MULTIPART_FORM_DATA+";charset=UTF-8",method=RequestMethod.POST)
	public pdfBeanDTO processPDF(@PathVariable("processPDF") String pathVar, @RequestParam("value") int varvalue,@RequestBody pdfSetter pdffileSetter, @RequestHeader HttpHeaders headers) {
//		String decodeValue = Base64.getDecoder().decode(headers.getFirst("token")).toString();
		String decodeValue = "granted";
		if(pathVar.equalsIgnoreCase("processPDF") && varvalue==1 && decodeValue.equalsIgnoreCase("granted")) {
			pdfBean = pdfProcess.processPdf(pdffileSetter);
			return pdfBean;
		}
		else {
			System.out.println("Encoded Oauth token is different");
		}
		return null;
	}
}
