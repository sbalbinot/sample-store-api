package com.store.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.store.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	
	// define o vencimento do boleto em 7 dias.. em uma situação real teria que chamar web service para gerar o boleto
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
	
}
