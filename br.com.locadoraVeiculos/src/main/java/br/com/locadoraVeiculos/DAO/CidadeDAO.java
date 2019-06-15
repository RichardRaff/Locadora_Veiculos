package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Cidade;

public class CidadeDAO {
private EntityManager em;

public CidadeDAO() {
	DAO dao = new DAO();
	em = dao.getEntity();
}

// Busca cidade por id no banco de dados
public Cidade getById(final int id) {
	return em.find(Cidade.class, id);
}

// Salvar cidade no banco de dados
public void save(Cidade c) {
	em.getTransaction().begin();
	em.persist(c);
	em.getTransaction().commit();
}

// Atualizar cidade no banco de dados
public void update(Cidade c) {
	em.getTransaction().begin();
	em.merge(c);
	em.getTransaction().commit();
}

// Remover cidade no banco de dados
public void delete(Cidade c) {
	em.getTransaction().begin();
	Cidade CidadeRemover = getById(c.getIdCidade());
	em.remove(CidadeRemover);
	em.getTransaction().commit();
}
}

