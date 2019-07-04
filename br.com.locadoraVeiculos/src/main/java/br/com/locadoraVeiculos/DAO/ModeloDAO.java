package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadoraVeiculos.model.Modelo;



public class ModeloDAO {
private EntityManager em;
	
	public ModeloDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	// Busca modelo por id no banco de dados
	public Modelo getById(final int id) {
		return em.find(Modelo.class, id);
	}
	
	// Salvar modelo no banco de dados
	public void save(Modelo m) {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	// Atualizar modelo no banco de dados
	public void update(Modelo m) {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
	}
	
	// Remover modelo no banco de dados
	public void delete(Modelo m) {
		em.getTransaction().begin();
		Modelo modeloRemover = getById(m.getIdModelo());
		em.remove(modeloRemover);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Modelo> buscarTodos() {
		em.getTransaction().begin();
		
		return em.createQuery("FROM " + Modelo.class.getName()).getResultList();
	}
	
	public List<Modelo> buscarNome(String modelo) {
		em.getTransaction().begin();
		String busca = "SELECT c FROM Modelo c WHERE c.modelo = :modelo";
		Query q = em.createQuery(busca);
		q.setParameter("modelo", modelo);
		List result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
		
	}
}