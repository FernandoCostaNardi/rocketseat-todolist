package com.sysconard.Glojas.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component(value = "uIUtil")
public class UIutil {

	public BigDecimal formatAmount(BigDecimal amount) {
		if (amount == null) {
			BigDecimal big = new BigDecimal("1.00");
			return big;
		}
		return amount;
	}

	public int converterParaInteger(BigDecimal amount) {
		int big = Integer.valueOf(amount.intValue());
		return big;
	}
	
	public String trimZeroEsquerda(String numeroNota) {
		
		String numeroNotaSemZero = numeroNota.replaceAll("^0*", "");
		
		return numeroNotaSemZero;
	}
	
}
