package br.edu.ifms.denatran.dto;

import java.io.Serializable;

import br.edu.ifms.denatran.model.Infracao;

public class InfracaoDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Integer pontos;
	private Double valor;
	
	
	public InfracaoDto() {
		
	}

	public InfracaoDto(Infracao obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.pontos = obj.getPontos();
		this.valor = obj.getValor();
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
