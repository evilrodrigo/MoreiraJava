package br.com.financeiro.teste;

import java.math.BigDecimal;

public class Teste {

	public static void main(String[] args) {
		
		BigDecimal a = new BigDecimal(1);

		System.out.println(a);

		a = a.add(new BigDecimal(10));

		System.out.println(a);

		a = a.add(new BigDecimal(10));

		System.out.println(a);
		
		a = a.add(new BigDecimal(30));
		
		System.out.println(a);
	}
}
