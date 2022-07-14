package com.sistema.core.model.servico;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sistema.core.model.ordemservico.OrdemServicoItem;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;

	private String nomeServico;

	private BigDecimal preco = BigDecimal.ZERO;

	private Integer quantidade;

	private String unidade;

	private BigDecimal desconto;

	@Column(name = "percentualdesconto")
	private Double percentualDesconto;
	
	@OneToMany(mappedBy = "servico")
	private List<OrdemServicoItem> ordemServicoItem;

	public Servico() {
		// TODO Auto-generated constructor stub
	}
	
	public Servico(long id, String nomeServico, BigDecimal preco, Integer quantidade, String unidade,
			BigDecimal desconto, Double percentualDesconto) {
		super();
		this.id = id;
		this.nomeServico = nomeServico;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.desconto = desconto;
		this.percentualDesconto = percentualDesconto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	
	
}
