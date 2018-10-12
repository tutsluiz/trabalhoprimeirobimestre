package br.com.primeirobimestre.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class DAO {
	
	@PersistenceUnit(unitName="TrabalhoPrimeiroBimestre")
	private static final EntityManagerFactory emFactory;
	
	static {
		emFactory = Persistence.createEntityManagerFactory("TrabalhoPrimeiroBimestre");
	}
	
	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	
	public static void fecharFactory() {
		emFactory.close();
	}

}
