package br.com.locadoraVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidade")
@NamedQuery(name="Cidade.getCidades",
			query = "SELECT c FROM Cidade c WHERE c.estado = :Estado")
public class Cidade {
	@Id
	@GeneratedValue
	private int idCidade;
	private String cidade;
	@ManyToOne
	private Estado estado;
	
	
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cidade;
	}
	
	
}
