package br.com.financeiro.cliente;

public class Cpf implements Documento {

	private String value;

	public Cpf(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}
