package bdd.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Table(uniqueConstraints = {@UniqueConstraint(name = "LOGIN_ID_UNIQUE", columnNames = {"loginId"})})
@Entity
@Table
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String loginId;

  @Column(nullable = false, length = 20)
  private String password;

  public boolean isMatch(String password) {
    return this.password.equals(password);
  }
}
