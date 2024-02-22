package bdd.domain.dao;

import bdd.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.Optional;

public class MemberJpaRepository implements MemberRepository {

  private final EntityManagerFactory emf;
  private final EntityManager em;
  private final EntityTransaction tx;

  public MemberJpaRepository(EntityManagerFactory emf) {
    this.emf = emf;
    this.em = emf.createEntityManager();
    this.tx = em.getTransaction();
  }

  @Override
  public Optional<Member> findByLoginId(String loginId) {
    try {
      Query query = em.createQuery(
          "SELECT COUNT(m) FROM bdd.domain.Member m WHERE m.loginId = :loginId");
      query.setParameter("loginId", loginId);

      Member member = (Member) query.getSingleResult();

      return Optional.ofNullable(member);
    } catch (Exception e) {

      throw new RuntimeException("Error checking member existence by loginId and password", e);
    }
  }
}
