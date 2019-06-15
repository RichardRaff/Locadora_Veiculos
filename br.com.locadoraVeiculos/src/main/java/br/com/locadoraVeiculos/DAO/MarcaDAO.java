package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

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
}