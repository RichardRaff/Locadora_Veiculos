package br.com.locadoraVeiculos.jpa;

import java.sql.Connection;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

    static Connection conn = null;
    EntityManagerFactory emf = null;

    public Conexao() {

        if (emf == null) {
            emf = createEntity();
        } else {
            getEntity();
        }
    }

    public EntityManagerFactory createEntity() {
    	emf = Persistence.createEntityManagerFactory("locadoraPU");
        return emf;
    }

    public void closeEMF() {
        emf.close();
    }

    public EntityManagerFactory getEntity() {
        return emf;
    }
}