package br.edu.ifms.denatran.dto;

import java.io.Serializable;

public class MultaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String cidade;
	private int ano;

	public MultaDto() {
		
	}

	public MultaDto(Integer id, String cidade, int ano) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}

}
