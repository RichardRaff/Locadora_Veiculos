package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Funcionario;

public class FuncionarioDAO {
private EntityManager em;

public FuncionarioDAO() {
	DAO dao = new DAO();
	em = dao.getEntity();
}

// Busca funcionario por id no banco de dados
public Funcionario getById(final int id) {
	return em.find(Funcionario.class, id);
}

// Salvar funcionario no banco de dados
public void save(Funcionario f) {
	em.getTransaction().begin();
	em.persist(f);
	em.getTransaction().commit();
}

// Atualizar funcionario no banco de dados
public void update(Funcionario f) {
	em.getTransaction().begin();
	em.merge(f);
	em.getTransaction().commit();
}

// Remover funcionario no banco de dados
public void delete(Funcionario f) {
	em.getTransaction().begin();
	Funcionario FuncionarioRemover = getById(f.getIdPessoa());
	em.remove(FuncionarioRemover);
	em.getTransaction().commit();
}
}
