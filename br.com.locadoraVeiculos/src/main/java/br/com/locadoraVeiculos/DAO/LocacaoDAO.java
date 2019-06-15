package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Locacao;

public class LocacaoDAO {
private EntityManager em;

public LocacaoDAO() {
	DAO dao = new DAO();
	em = dao.getEntity();
}

// Busca locacao por id no banco de dados
public Locacao getById(final int id) {
	return em.find(Locacao.class, id);
}

// Salvar locacao no banco de dados
public void save(Locacao l) {
	em.getTransaction().begin();
	em.persist(l);
	em.getTransaction().commit();
}

// Atualizar locacao no banco de dados
public void update(Locacao l) {
	em.getTransaction().begin();
	em.merge(l);
	em.getTransaction().commit();
}

// Remover locacao no banco de dados
public void delete(Locacao l) {
	em.getTransaction().begin();
	Locacao LocacaoRemover = getById(l.getIdLocacao());
	em.remove(LocacaoRemover);
	em.getTransaction().commit();
}
}

