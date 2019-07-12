package com.srpingbootPDFSetter.processController;

import java.util.Base64;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srpingbootPDFSetter.dto.pdfBeanDTO;
import com.srpingbootPDFSetter.service.pdfService;

@RestController
@RequestMapping("/")
public class pdfProcessController {

	@Autowired
	public pdfService pdfServiceClass;
	@Autowired
	public pdfBeanDTO pdfBean;
	@RequestMapping(value="/readPdf",produces=MediaType.APPLICATION_JSON,method=RequestMethod.GET)
	public ResponseEntity<Object> setPDFAndCall() {
		HttpHeaders responseHeader = new HttpHeaders();
		String token = Base64.getEncoder().encodeToString("granted".getBytes());
		responseHeader.add("token", token);
		pdfBean = pdfServiceClass.pdfProcess(responseHeader);
		return new ResponseEntity<Object>(pdfBean,HttpStatus.OK);
	}
}
