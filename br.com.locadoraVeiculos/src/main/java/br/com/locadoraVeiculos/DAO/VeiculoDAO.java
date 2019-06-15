package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Veiculo;



public class VeiculoDAO {
private EntityManager em;
	
	public VeiculoDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	// Busca veiculo por id no banco de dados
	public Veiculo getById(final int id) {
		return em.find(Veiculo.class, id);
	}
	
	// Salvar veiculo no banco de dados
	public void save(Veiculo v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}
	
	// Atualizar veiculo no banco de dados
	public void update(Veiculo v) {
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
	}
	
	// Remover veiculo no banco de dados
	public void delete(Veiculo v) {
		em.getTransaction().begin();
		Veiculo veiculoRemover = getById(v.getIdVeiculos());
		em.remove(veiculoRemover);
		em.getTransaction().commit();
	}
}