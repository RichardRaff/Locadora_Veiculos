package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.locadoraVeiculos.model.Estado;

public class EstadoDAO {
	private EntityManager em;

	public EstadoDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}

// Busca estado por id no banco de dados
	public Estado getById(final int id) {
		return em.find(Estado.class, id);
	}
	
	public Estado getByName(String estadoCombo) {
		em.getTransaction().begin();
		TypedQuery<Estado> queryEstado = em.createNamedQuery("Estado.getIdEstado", Estado.class);
		queryEstado.setParameter("estado", estadoCombo);
		return queryEstado.getSingleResult();
		
	}
	

// Salvar estado no banco de dados
	public void save(Estado e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

// Atualizar estado no banco de dados
	public void update(Estado e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}

// Remover estado no banco de dados
	public void delete(Estado e) {
		em.getTransaction().begin();
		Estado EstadoRemover = getById(e.getIdEstado());
		em.remove(EstadoRemover);
		em.getTransaction().commit();
	}
	
	public List<Estado> getAll(){
		em.getTransaction().begin();
		return em.createQuery("FROM " + Estado.class.getName()).getResultList();
	}
	
}
