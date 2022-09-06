package br.edu.ifms.denatran.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Infracao implements Serializable {

	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Integer pontos;
	private Double valor;
	@OneToMany(mappedBy = "infracao")
	private List<Multa> multas= new ArrayList<Multa>();
	
	public Infracao() {
		
	}
	
	public Infracao(Integer id, String descricao, Integer pontos, Double valor) {
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

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
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
		Infracao other = (Infracao) obj;
		return Objects.equals(id, other.id);
	}
	
}
