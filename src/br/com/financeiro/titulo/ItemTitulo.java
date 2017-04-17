package br.com.financeiro.titulo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_TITULO_ITEM", sequenceName = "SEQ_TITULO_ITEM", initialValue = 1)
public class ItemTitulo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TITULO_ITEM")
	private Integer id;
	private String servico;
	private BigDecimal valor;

	@Deprecated //Apenas para uso do Hibernate
	public ItemTitulo() {
	}

	public ItemTitulo(String servico, BigDecimal valor) {
		this.servico = servico;
		this.valor = valor;
	}

	public String getServico() {
		return servico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	

}
