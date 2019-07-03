package br.com.locadoraVeiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_Estado")
@NamedQuery(name="Estado.getIdEstado",
query = "SELECT e FROM Estado e WHERE e.estado = :estado")
public class Estado {
	
	@Id
	@GeneratedValue
	private int idEstado;
	private String ufEstado;
	private String estado;
	
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getUfEstado() {
		return ufEstado;
	}
	public void setUfEstado(String ufEstado) {
		this.ufEstado = ufEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.estado;
	}
	

}
