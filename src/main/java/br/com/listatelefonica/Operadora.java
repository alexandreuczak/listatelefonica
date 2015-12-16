package br.com.listatelefonica;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="operadoras")
public class Operadora extends Persistable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="nome")
	private String nome;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	public Operadora() {
		this(null, null, null, null);
	}

	public Operadora(Integer codigo, String nome, String categoria, BigDecimal preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
