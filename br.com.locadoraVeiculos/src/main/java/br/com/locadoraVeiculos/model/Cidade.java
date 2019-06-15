package br.com.locadoraVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidade")
public class Cidade {
	@Id
	@GeneratedValue
	private int idCidade;
	private String ufCidade;
	private String cidade;
	@ManyToOne
	private Estado estado;
	
	
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getUfCidade() {
		return ufCidade;
	}
	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
