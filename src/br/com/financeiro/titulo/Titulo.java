package br.com.financeiro.titulo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.financeiro.cliente.Cliente;

/**
 * Classe de títulos
 * 
 * @author Rodrigo
 *
 */
@Entity
@SequenceGenerator(name = "SEQ_TITULO", sequenceName = "SEQ_TITULO", initialValue = 1)
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TITULO")
	private Integer id;
	private Calendar dataTitulo;
	private Cliente cliente;
	private BigDecimal valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataVencimento;
	private EstadoTitulo estadoTitulo;
	@OneToMany
	@MapKey(name="LOCALE")
	private Map<String, ItemTitulo> items;
	
	@Deprecated //Apenas para uso do Hibernate
	public Titulo() {
	}

	public Titulo(Cliente cliente) {
		this.dataTitulo = Calendar.getInstance(); // Hoje
		this.cliente = cliente;
		this.valorTotal = new BigDecimal(0.0);
		this.items = new HashMap<String, ItemTitulo>();
		this.estadoTitulo = new Aberto();
		itemObrigatorio(cliente);
	}

	/**
	 * Por via de regra, todo título é criado com um item de MENSALIDADE incluso
	 * 
	 * @param cliente
	 */
	private void itemObrigatorio(Cliente cliente) {
		addItem(new ItemTitulo("MENSALIDADE", cliente.getValorMensal()));
	}

	public Calendar getDataTitulo() {
		return dataTitulo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getValor() {
		return valorTotal;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public EstadoTitulo getEstadoTitulo() {
		return estadoTitulo;
	}

	public Map<String, ItemTitulo> getItems() {
		return items;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Adiciona um item ao título e soma seu valor ao valor total
	 * 
	 * @param item
	 */
	public void addItem(ItemTitulo item) {
		this.items.put(item.getServico(), item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}

	/**
	 * Remove um item do título e atualiza o valor total
	 * 
	 * @param item
	 */

	public void removeItem(ItemTitulo item) {
		this.items.remove(item.getServico());
		this.valorTotal = this.valorTotal.subtract(item.getValor());
	}

	/**
	 * Setas a data de vencimento caso seja maior ou igual a data do título
	 * 
	 * @param dataVencimento
	 */
	public void setDataVencimento(Calendar dataVencimento) {
		if (dataVencimento.before(this.dataTitulo)) {
			throw new RuntimeException("Data do vencimento não pode ser anterior a data do título");
		}
		this.dataVencimento = dataVencimento;
	}

	public void setEstadoTitulo(EstadoTitulo estadoTitulo) {
		this.estadoTitulo = estadoTitulo;
		
	}

}
