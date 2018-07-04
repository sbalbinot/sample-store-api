package com.store.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.store.domain.Cliente;
import com.store.repositories.ClienteRepository;
import com.store.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cli = clienteRepository.findByEmail(email);
		
		if (cli == null) {
			throw new ObjectNotFoundException("Email não encontrado.");
		}
		
		String newPass = newPassword();
		cli.setSenha(encoder.encode(newPass));
		clienteRepository.save(cli);
		
		emailService.sendNewPasswordEmail(cli, newPass);
	}
	
	private String newPassword() {
		char[] vet = new char[10];
		
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		
		return new String(vet);
	}
	
	private char randomChar() {
		int opt = random.nextInt(3);
		if (opt == 0) { // gera um dígito
			return (char) (random.nextInt(10) + 48);
		} else if (opt == 1) { // gera letra maiúscula
			return (char) (random.nextInt(26) + 65);
		} else { // gera letra minúscula
			return (char) (random.nextInt(26) + 97);
		}
	}
	
}
