package br.com.financeiro.titulo;

public class Baixado implements EstadoTitulo {

	@Override
	public void darBaixa(Titulo titulo) {
		throw new RuntimeException("T�tulo j� est� baixado");
	}

}
