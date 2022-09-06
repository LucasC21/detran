package br.edu.ifms.denatran.dto;

import java.io.Serializable;

public class InfracaoDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Integer pontos;
	private Double valor;
	
	
	public InfracaoDto() {
		
	}

	public InfracaoDto(Integer id, String descricao, Integer pontos, Double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pontos = pontos;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
