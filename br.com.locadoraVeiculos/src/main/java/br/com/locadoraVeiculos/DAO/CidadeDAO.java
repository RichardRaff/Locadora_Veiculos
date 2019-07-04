package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.locadoraVeiculos.model.Cidade;
import br.com.locadoraVeiculos.model.Estado;

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
	public Cidade getByName(String cidadeCombo) {
		em.getTransaction().begin();
		TypedQuery<Cidade> queryCidade = em.createNamedQuery("Cidade.getIdCidade", Cidade.class);
		queryCidade.setParameter("city", cidadeCombo);
		return queryCidade.getSingleResult();
		
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
	
	public List<Cidade> getCidadesById(Estado idEstado){
		TypedQuery<Cidade> query = em.createNamedQuery("Cidade.getCidades", Cidade.class);
		query.setParameter("Estado", idEstado);
		return query.getResultList();
		
		
	}
}
