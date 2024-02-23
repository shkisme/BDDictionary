package bdd.domain.dictionary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Word {

  @Id
  @GeneratedValue
  private Long id;

  private String value;

  public Word(String value) {
    this.value = value;
  }

  protected Word() {
  }
}
