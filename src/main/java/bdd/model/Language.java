package bdd.model;

public class Language {

  private String name;

  public Language(String name) {
    this.name = name;
  }

  public boolean isMatch(String name) {
    return this.name.equals(name);
  }
}
