package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		c.setTitular("Rodrigo");
		c.setNumero(1234);
		c.setAgencia(4321);
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
}
