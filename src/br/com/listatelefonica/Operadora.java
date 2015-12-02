package br.com.listatelefonica;

import java.math.BigDecimal;

public class Operadora {
	
	private Integer codigo;
	private String nome;
	private String categoria;
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
