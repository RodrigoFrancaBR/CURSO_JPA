package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		
		c.setTitular("Marcelo");
		c.setNumero(12345);
		c.setAgencia(54321);
		c.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(c);
		
		// c.setSaldo(1000.0);
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		
		c.setSaldo(2000.0);
		
		em2.getTransaction().begin();
		
		em2.merge(c);
		
		em2.getTransaction().commit();
		
		System.out.println(c.getId());
		
		
	}
}
