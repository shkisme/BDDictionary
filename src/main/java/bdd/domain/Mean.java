package bdd.domain;

import bdd.domain.dao.Language;

public class Mean {

  private Language language;

  private String name;

  public Mean(Language language, String name) {
    this.language = language;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isLanguage(Language language) {
    return this.language.equals(language);
  }

  @Override
  public String toString() {
    return name + "(" + language + ")";
  }
}
