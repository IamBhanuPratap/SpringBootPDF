package com.srpingbootPDFdemo.pdfProcessImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srpingbootPDFdemo.dto.pdfBeanDTO;
import com.srpingbootPDFdemo.dto.pdfSetter;
import com.srpingbootPDFdemo.service.PdfProcessService;

@Service
public class PdfServiceImpl implements PdfProcessService{

	@Autowired
	public pdfBeanDTO pdfBean;
	@Override
	public pdfBeanDTO processPdf(pdfSetter pdffileSetter) {
		File pdfFile = pdffileSetter.getPdfFile();
		try {
			BufferedReader buffread = new BufferedReader(new FileReader(pdfFile));
			String line = buffread.readLine();
			while(line!=null) {
				if(line.contains("Transaction Status")) {
					pdfBean.setTransactionStatus(line.substring(18).trim());
				}
				else if(line.contains("Account ID")) {
					pdfBean.setAccountId(line.substring(10).trim());
				}
				else if(line.contains("Transaction ID")) {
					pdfBean.setTransactionId(line.substring(14).trim());
				}
				else if(line.contains("Transaction Date and Time")) {
					pdfBean.setTransactionDate(line.substring(25).trim());
				}
				else if(line.contains("Transaction Reference Number")) {
					pdfBean.setTransactionReference(line.substring(28).trim());
				}
				else if (line.contains("Email Address")) {
					pdfBean.setEmailId(line.substring(13).trim());
				}
				else if(line.contains("Transaction Amount")) {
					pdfBean.setTransactionAmount(line.substring(18).trim());
				}
				else if(line.contains("Payment Mode")) {
					pdfBean.setPaymentMode(line.substring(12).trim());
				}
			}
			buffread.close();
		}
		catch(Exception e) {
			System.out.println("IO exception while reading the file");
		}
		
		return pdfBean;
	}
}
