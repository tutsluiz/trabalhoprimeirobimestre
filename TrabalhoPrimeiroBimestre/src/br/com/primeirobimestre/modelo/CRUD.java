package br.com.primeirobimestre.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateError;

public class CRUD {

	public static void inserir(Produto prod) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(prod);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Produto salvo com Sucesso!");
			
		} catch (HibernateError ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
		List<Produto> produtos = null;
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
			produtos = entityManager.createQuery("FROM Produto").getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();			
		} catch (HibernateError ex) {
			ex.printStackTrace();
		}
		return produtos;
	}
	
	public static void atualizar(int id, String nome, String descricao, int quantidade, double valor) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			Produto prod = entityManager.find(Produto.class, new Integer(id));
			entityManager.getTransaction().begin();
			   prod.setNome(nome);
			   prod.setDescricao(descricao);
			   prod.setQuantidade(quantidade);
			   prod.setValor(valor);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Produto atualizado com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void atualizarQuantidade(int id, int quantidade) {
		try {
			EntityManager entityManager = DAO.getEntityManager();
			Produto prod = entityManager.find(Produto.class, new Integer(id));
			entityManager.getTransaction().begin();
			   prod.setQuantidade(quantidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Produto" + prod.getNome()+" atualizado com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void remover(int id) {
		try {
			EntityManager entityManager =  DAO.getEntityManager();
			entityManager.getTransaction().begin();
			Produto prod = entityManager.find(Produto.class, new Integer(id));
			entityManager.remove(prod);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Produto " + prod.getNome() + "REmovido com Sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
