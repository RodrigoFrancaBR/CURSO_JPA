package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// transient

		Conta c = new Conta();
		c.setTitular("Almiro");
		c.setAgencia(123);
		c.setNumero(12);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// transient - > Managed
		em.persist(c);
		// Managed - > Removed
		em.remove(c);
		
		em.getTransaction().commit();
	}

}
