package com.srpingbootPDFSetter.serviceImpl;

import java.io.File;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.srpingbootPDFSetter.dto.pdfBeanDTO;
import com.srpingbootPDFSetter.dto.pdfSetter;
import com.srpingbootPDFSetter.service.pdfService;

@Service
public class pdfServiceImpl implements pdfService{

	@Autowired
	public pdfSetter pdfFileSetter;
	@Autowired
	public pdfBeanDTO pdfbean;
	@Autowired
	public RestTemplate restTemp;
	@Override
	public pdfBeanDTO pdfProcess(HttpHeaders responseHeader) {
		
		File pdfFileCreate = new File("F://ebill.pdf");
		pdfFileSetter.setPdfFile(pdfFileCreate);
		try {
			responseHeader.setContentType(MediaType.MULTIPART_FORM_DATA);
			HttpEntity<pdfSetter> requestEntity = new HttpEntity<pdfSetter>(pdfFileSetter,responseHeader);
			MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
			mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
			restTemp.getMessageConverters().add(mappingJackson2HttpMessageConverter);
			ResponseEntity<pdfBeanDTO> resEntity=restTemp.exchange("http://localhost:8080/processPDF?value=1", HttpMethod.POST, requestEntity, pdfBeanDTO.class);
			pdfbean=resEntity.getBody();
//			pdfbean = restTemp.postForObject("http://localhost:8080/processPDF?value=1",null, pdfBeanDTO.class);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception while making rest call to pdf processing controller.");
		}
		return pdfbean;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
