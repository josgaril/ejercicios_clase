package com.ipartek.formacion.hibernateejemplo;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory entityManagerFactory = 
    			Persistence.createEntityManagerFactory( "com.ipartek.formacion.hibernateejemplo" );
    	
    	EntityManager em = entityManagerFactory.createEntityManager();
   
    	em.getTransaction().begin();
    	
    	Rol admin = new Rol("ADMIN");
    	Rol user = new Rol("USER");
    	
    	em.persist(admin);
    	em.persist(user);
    	
    	em.persist(new Usuario("jose@email.com", "jose", admin));
    	em.persist(new Usuario("alberto@email.com", "alberto", user));
    	em.persist(new Usuario("leticia@email.com", "leticia", user));
    	
    	em.getTransaction().commit();
    	
    	em.clear();
    	
    	em.getTransaction().begin();
    	
    	List<Usuario> usuarios = em.createQuery("select u from Usuario u inner join fetch u.rol", Usuario.class).getResultList();
    	
    	for(Usuario usuario: usuarios) {
    		System.out.println(usuario);
    		
    		if(usuario.getId() == 2) {
    			System.out.println("\tEl usuario tiene este rol");
    			System.out.println("\t" + usuario.getRol());
    			System.out.println("\t" + usuario.getRol().getUsuarios());
    		}
    	}
    	
    	em.getTransaction().commit();
    	
    	//Validaciones
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Usuario>> errores = 
        		validator.validate(new Usuario(1L, "email@email.com", null, "a", null, null));
        
        for(ConstraintViolation<Usuario> error: errores) {
        	System.out.println(error.getPropertyPath() + ": " + error.getMessage());
        }
    }
}
