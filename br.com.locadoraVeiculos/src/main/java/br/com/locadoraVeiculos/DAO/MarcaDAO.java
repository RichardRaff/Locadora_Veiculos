package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.locadoraVeiculos.model.Marca;



public class MarcaDAO {
private EntityManager em;
	
	public MarcaDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
	}
	
	// Busca marca por id no banco de dados
	public Marca getById(final int id) {
		return em.find(Marca.class, id);
	}
	
	// Salvar marca no banco de dados
	public void save(Marca m) {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	// Atualizar marca no banco de dados
	public void update(Marca m) {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
	}
	
	// Remover marca no banco de dados
	public void delete(Marca m) {
		em.getTransaction().begin();
		Marca MarcaRemover = getById(m.getIdMarca());
		em.remove(MarcaRemover);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Marca> buscarTodos() {
		em.getTransaction().begin();
		
		return em.createQuery("FROM " + Marca.class.getName()).getResultList();
	}
	
	public List<Marca> buscarNome(String marca) {
		em.getTransaction().begin();
		String busca = "SELECT c FROM Marca c WHERE c.marca = :marca";
		Query q = em.createQuery(busca);
		q.setParameter("marca", marca);
		List result = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
		
	}
}
