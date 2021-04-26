package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.SorveteDAO;
import entidade.Sorvete;
import util.JpaUtil;

public class SorveteDAOImpl implements SorveteDAO {

	private EntityManager em;
	private EntityTransaction et;

	public void inserir(Sorvete sorvete) {
		try {
			this.em = JpaUtil.getEntityManager();

			et = em.getTransaction();
			et.begin();
			em.persist(sorvete);
			et.commit();
			System.out.println("Sorvete inserido com sucesso!");

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
				System.out.println("Erro ao inserir sorvete: " + e.getMessage());
			}

		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	public void remover(String nome) {
		try {
			this.em = JpaUtil.getEntityManager();

			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Sorvete.class, nome));
			et.commit();
			System.out.println("Sorvete removido com sucesso!");

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
				System.out.println("Erro ao remover sorvete: " + e.getMessage());
			}

		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Sorvete> listarTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Sorvete e");
		List<Sorvete> listarSorvetes = query.getResultList();
		em.close();
		return listarSorvetes;
	}

}
