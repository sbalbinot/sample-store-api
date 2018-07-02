package com.store.services;

import org.springframework.mail.SimpleMailMessage;

import com.store.domain.Pedido;

public interface EmailService {

	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationEmail(Pedido obj);
	
}
