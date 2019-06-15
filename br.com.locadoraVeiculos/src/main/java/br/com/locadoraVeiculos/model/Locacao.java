package br.com.locadoraVeiculos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tb_locacao")
public class Locacao {
	@Id
	@GeneratedValue
	private int idLocacao;
	private LocalDate dataLocacao;
	private LocalTime horaLocacao;
	private LocalDate dataDevolucao;
	private LocalTime horaDevolucao;
	private long quilometragem;
	private double valorLocacao;
	private double valorCalcao;
	
	
	@OneToMany
	private List<Veiculo> veiculos;

	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Funcionario funcionario;
	
	
	public int getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}
	public LocalDate getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public LocalTime getHoraLocacao() {
		return horaLocacao;
	}
	public void setHoraLocacao(LocalTime horaLocacao) {
		this.horaLocacao = horaLocacao;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public LocalTime getHoraDevolucao() {
		return horaDevolucao;
	}
	public void setHoraDevolucao(LocalTime horaDevolucao) {
		this.horaDevolucao = horaDevolucao;
	}
	public long getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(long quilometragem) {
		this.quilometragem = quilometragem;
	}
	public double getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	public double getValorCalcao() {
		return valorCalcao;
	}
	public void setValorCalcao(double valorCalcao) {
		this.valorCalcao = valorCalcao;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	

}
