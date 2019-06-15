package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

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
}

