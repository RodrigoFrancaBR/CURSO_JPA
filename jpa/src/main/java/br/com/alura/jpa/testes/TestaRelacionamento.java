package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Ana Maria");
		conta.setAgencia(111);
		conta.setNumero(54321);
		conta.setSaldo(100.22);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));

		movimentacao.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.persist(movimentacao);

		em.getTransaction().commit();
		em.close();
	}
}
