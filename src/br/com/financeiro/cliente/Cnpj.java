package br.com.financeiro.cliente;

public class Cnpj implements Documento {

	private String value;

	public Cnpj(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
