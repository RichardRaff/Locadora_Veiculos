package br.com.locadoraVeiculos.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_marca")
public class Marca {
		@Id
		@GeneratedValue
		private int idMarca;
		private String descricacao;
		
		
		public int getIdMarca() {
			return idMarca;
		}
		public void setIdMarca(int idMarca) {
			this.idMarca = idMarca;
		}
		public String getDescricacao() {
			return descricacao;
		}
		public void setDescricacao(String descricacao) {
			this.descricacao = descricacao;
		}
		
	
	
	
}
