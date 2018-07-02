package com.store.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.store.domain.Pedido;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmailHtml (MimeMessage msg);
	
	void sendOrderConfirmationEmailHtml(Pedido obj);
	
}