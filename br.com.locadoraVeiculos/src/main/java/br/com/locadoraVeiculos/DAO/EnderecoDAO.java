package br.com.locadoraVeiculos.DAO;

import javax.persistence.EntityManager;

import br.com.locadoraVeiculos.model.Endereco;



public class EnderecoDAO {
private EntityManager em;

public EnderecoDAO() {
	DAO dao = new DAO();
	em = dao.getEntity();
}

// Busca endereco por id no banco de dados
public Endereco getById(final int id) {
	return em.find(Endereco.class, id);
}

// Salvar endereco no banco de dados
public void save(Endereco e) {
	em.getTransaction().begin();
	em.persist(e);
	em.getTransaction().commit();
}

// Atualizar endereco no banco de dados
public void update(Endereco e) {
	em.getTransaction().begin();
	em.merge(e);
	em.getTransaction().commit();
}

// Remover endereco no banco de dados
public void delete(Endereco e) {
	em.getTransaction().begin();
	Endereco EnderecoRemover = getById(e.getIdEndereco());
	em.remove(EnderecoRemover);
	em.getTransaction().commit();
}
}

