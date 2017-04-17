package br.com.financeiro.titulo;

import br.com.financeiro.dao.TituloDao;

public class Aberto implements EstadoTitulo{

	@Override
	public void darBaixa(Titulo titulo) {
		titulo.setEstadoTitulo(new Baixado());
		TituloDao.salvaTitulo(titulo);
	}

}
