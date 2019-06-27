package br.com.locadoraVeiculos.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.com.locadoraVeiculos.model.Login;

public class LoginDAO {
	
	
	private EntityManager em;
	
	public LoginDAO() {
		DAO dao = new DAO();
		em = dao.getEntity();
		
	}
	
	public boolean getLogin(String user, String senha) {
		System.out.println(user+senha);
		boolean autenticate = false;
		String sql = "FROM Login c WHERE c.email = :email and c.senha = :pwd";
    	Query sqlLogin = em.createQuery(sql);
    	sqlLogin.setParameter("email", user);
    	sqlLogin.setParameter("pwd", senha);
    	List<Login> loginUser = sqlLogin.getResultList();
    	
    	if (loginUser.size() > 0) return true;
		
		return autenticate;
	}
	
	public void save(Login l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}
	

}
