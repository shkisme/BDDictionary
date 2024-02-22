package bdd.domain.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class MemberJpaRepository implements MemberRepository {

  private final EntityManagerFactory emf;
  private final EntityManager em;
  private final EntityTransaction tx;

  public MemberJpaRepository(EntityManagerFactory emf) {
    this.emf = emf;
    this.em = emf.createEntityManager();
    this.tx = em.getTransaction();
  }
}
