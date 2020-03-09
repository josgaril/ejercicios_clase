package com.ipartek.formacion.hibernatemasajes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = 
    			Persistence.createEntityManagerFactory( "com.ipartek.formacion.hibernate_salon_de_masajes" );
    	
    	EntityManager em = entityManagerFactory.createEntityManager();
    	
    	em.getTransaction().begin();
    	
    	em.persist(new Cliente("jose", "josete", "71121212M"));
    	em.persist(new Cliente("alberto", "albertete", "78545215L"));
    	em.persist(new Cliente("leti", "leticiete", "78521458O"));

    	
    }
}
