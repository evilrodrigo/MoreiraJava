package br.com.financeiro.cliente;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author Rodrigo Classe de clientes
 */
@Entity
@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", initialValue = 1)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	private Integer id;
	private String nome;
	private String razaoSocial;
	private Documento documento;
	@OneToOne
	private Endereco endereco;
	private BigDecimal valorMensal;

	@Deprecated //Apenas para uso do Hibernate
	public Cliente() {
	}

	/**
	 * Inicializa com valor mensal zerado
	 */
	public Cliente(String nome, String razaoSocial, Documento documento, Endereco endereco) {
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.documento = documento;
		this.endereco = endereco;
		this.valorMensal = new BigDecimal(0.0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(BigDecimal valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getDocumento() {
		return documento.getValue();
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
