package com.sysconard.Glojas.util;

import java.util.ArrayList;
import java.util.List;

public class OperacaoUtil {

	public List<String> operacaoTroca() {
		List<String> operacaoTroca = new ArrayList<String>();
		operacaoTroca.add("000015");
		operacaoTroca.add("000048");
		return operacaoTroca;
	}

	public List<String> operacaoVenda() {
		List<String> operacaoVenda = new ArrayList<String>();
		operacaoVenda.add("000999");
		operacaoVenda.add("000007");
		operacaoVenda.add("000001");
		return operacaoVenda;
	}

}
