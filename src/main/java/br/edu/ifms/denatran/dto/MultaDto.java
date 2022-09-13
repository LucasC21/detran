package br.edu.ifms.denatran.dto;

import java.io.Serializable;

import br.edu.ifms.denatran.model.Multa;

public class MultaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String cidade;
	private int ano;

	public MultaDto() {
		
	}

	public MultaDto(Multa obj) {
		super();
		this.id = obj.getId();
		this.cidade = obj.getCidade();
		this.ano = obj.getAno();
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
