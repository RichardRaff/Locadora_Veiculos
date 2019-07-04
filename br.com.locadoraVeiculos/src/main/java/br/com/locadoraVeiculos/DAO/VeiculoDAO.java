package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> buscarTodos() {
		em.getTransaction().begin();
		
		return em.createQuery("FROM " + Veiculo.class.getName()).getResultList();
	}
	
	public List<Veiculo> buscarNome(String placa) {
		em.getTransaction().begin();
		String busca = "SELECT c FROM Veiculo c WHERE c.placa = :placa";
		Query q = em.createQuery(busca);
		q.setParameter("placa", placa);
		List result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
		
	}
}