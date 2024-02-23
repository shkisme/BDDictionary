package demo;

import java.util.Objects;

public class Language {

  private String name;

  public Language(String name) {
    this.name = name;
  }

  public boolean isMatch(String name) {
    return this.name.equals(name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Language language = (Language) o;
    return Objects.equals(name, language.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
