package br.com.financeiro.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.financeiro.titulo.Titulo;

/**
 * Classe Dao para títulos
 * 
 * @author Rodrigo
 *
 */
public class TituloDao {

	private static Map<Integer, Titulo> mapa = new HashMap<Integer, Titulo>();

	public static void salvaTitulo(Titulo titulo) {
		mapa.put(titulo.getId(), titulo);
	}

	public static Titulo getTitulo(Long numero) {
		return mapa.get(numero);
	}
}
