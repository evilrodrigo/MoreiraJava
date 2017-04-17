package br.com.financeiro.teste;

import javax.persistence.EntityManager;

import br.com.financeiro.cliente.Cliente;
import br.com.financeiro.utils.JPAUtils;

public class TestaApp {
	public static void main(String[] args) {

		EntityManager em = new JPAUtils().getEntityManager();

		em.getTransaction().begin();

		// manager.persist(new Cliente()); - Salva os dados e deixa o objeto Managed

		/**
		 * Find deixa o objeto Managed Sincronizado com o BD, alterou o objeto,
		 * o update é realizado no BD também.
		 */
		Cliente cli = em.find(Cliente.class, 1);
		System.out.println(cli.getNome());

		em.getTransaction().commit();

		/**
		 * Transforma o objeto em Detached (Pós Managed) Não está mais
		 * sincronizado com o BD
		 */
		em.close();

		EntityManager em2 = new JPAUtils().getEntityManager();
		em2.getTransaction().begin();

		/**
		 * Merge retorna o objeto para Managed
		 */
		em2.merge(cli);
		
		/**
		 * Deleta do BD
		 */
		em2.remove(cli);

		em2.getTransaction().commit();
		em2.close();
	}
}
