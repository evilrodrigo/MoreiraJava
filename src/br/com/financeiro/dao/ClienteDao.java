package br.com.financeiro.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.financeiro.cliente.Cliente;

/**
 * Classe Dao para clientes
 * 
 * @author Rodrigo
 *
 */
public class ClienteDao {

	private Map<String, Cliente> mapa = new HashMap<String, Cliente>();

	public void salvaCliente(Cliente cliente) {
		mapa.put(cliente.getDocumento(), cliente);
	}

	public Cliente getCliente(String documento) {
		return mapa.get(documento);
	}
}
