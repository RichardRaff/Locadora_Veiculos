package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Pessoa;

public class PessoaDAO {
private EntityManager em;

public PessoaDAO() {
	DAO dao = new DAO();
	em = dao.getEntity();
}

// Busca pessoa por id no banco de dados
public Pessoa getById(final int id) {
	return em.find(Pessoa.class, id);
}

// Salvar pessoa no banco de dados
public void save(Pessoa p) {
	em.getTransaction().begin();
	em.persist(p);
	em.getTransaction().commit();
}

// Atualizar pessoa no banco de dados
public void update(Pessoa p) {
	em.getTransaction().begin();
	em.merge(p);
	em.getTransaction().commit();
}

// Remover pessoa no banco de dados
public void delete(Pessoa p) {
	em.getTransaction().begin();
	Pessoa PessoaRemover = getById(p.getIdPessoa());
	em.remove(PessoaRemover);
	em.getTransaction().commit();
}
}

