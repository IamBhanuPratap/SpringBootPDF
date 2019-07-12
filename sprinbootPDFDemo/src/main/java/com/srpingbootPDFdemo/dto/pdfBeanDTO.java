package com.srpingbootPDFdemo.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class pdfBeanDTO {

	@JsonProperty("Transaction Status")
	private String transactionStatus;
	@JsonProperty("Transaction ID")
	private String transactionId;
	@JsonProperty("Transaction Date")
	private String transactionDate;
	@JsonProperty("Transaction Reference")
	private String transactionReference;
	@JsonProperty("Account ID")
	private String accountId;
	@JsonProperty("Email ID")
	private String emailId;
	@JsonProperty("Transaction Amount")
	private String transactionAmount;
	@JsonProperty("Payment Mode")
	private String paymentMode;
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionReference() {
		return transactionReference;
	}
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
