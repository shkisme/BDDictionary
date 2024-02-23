package bdd.domain.member;

import static bdd.domain.member.MemberType.NON_MEMBER;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class Member {

  private static final AtomicLong index = new AtomicLong(0);

  @Id
  @GeneratedValue
  private Long id;

  private String loginId;

  private String password;

  private MemberType memberType;

  private Member(Long id, String loginId, String password, MemberType memberType) {
    this.id = id;
    this.loginId = loginId;
    this.password = password;
    this.memberType = memberType;
  }

  public Member(String loginId, String password, MemberType memberType) {
    this(index.incrementAndGet(), loginId, password, memberType);
  }

  public Member(MemberType memberType) {
    this.memberType = memberType;
  }

  protected Member() {
  }

  public boolean isNonMember() {
    return this.memberType == NON_MEMBER;
  }

  public boolean isSameLoginId(String loginId) {
    return this.loginId.equals(loginId);
  }

  public boolean isSamePassword(String password) {
    return this.password.equals(password);
  }

  @Override
  public String toString() {
    return "%d번 id : %s".formatted(id, loginId);
  }
}
