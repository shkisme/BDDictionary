package bdd.domain.member;

import jakarta.persistence.Id;
import java.util.concurrent.atomic.AtomicLong;

public class Member {

  private static final AtomicLong index = new AtomicLong(1);

  @Id
  private Long id;

  private String loginId;

  private String password;

  public Member(String loginId, String password) {
    this(index.incrementAndGet(), loginId, password);
  }

  public Member(Long id, String loginId, String password) {
    this.id = id;
    this.loginId = loginId;
    this.password = password;
  }

  public boolean isSameLoginId(String loginId) {
    return this.loginId.equals(loginId);
  }

  public boolean isSamePassword(String password) {
    return this.password.equals(password);
  }
}
