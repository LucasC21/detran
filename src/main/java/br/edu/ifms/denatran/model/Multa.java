package br.edu.ifms.denatran.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Multa implements Serializable {

	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cidade;
	private int ano;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="infracao_id")
	private Infracao infracao;
	
	public Multa() {
	
	}

	public Multa(Integer id, String cidade, Carro carro,  int ano, Infracao infracao) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
		this.carro = carro;
		this.infracao = infracao;
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

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multa other = (Multa) obj;
		return Objects.equals(id, other.id);
	}

}
