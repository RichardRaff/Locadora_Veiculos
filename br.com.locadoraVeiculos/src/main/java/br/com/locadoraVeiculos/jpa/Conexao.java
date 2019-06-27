package br.com.locadoraVeiculos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

    
	
    EntityManagerFactory emf = null;
    EntityManager em;

    public Conexao() {

        if (emf == null) {
            emf = createEntity();
        } else {
            getEntityFactory();
        }
    }

    public EntityManagerFactory createEntity() {
    	emf = Persistence.createEntityManagerFactory("locadoraPU");
        return emf;
    }

    public void closeEMF() {
        emf.close();
    }

    public EntityManagerFactory getEntityFactory() {
        return emf;
    }
    
    public EntityManager getEntity() {
    	return emf.createEntityManager();
    }
    
    
}