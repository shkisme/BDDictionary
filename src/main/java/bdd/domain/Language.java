package bdd.domain;

import java.util.Arrays;

public enum Language {
  KOREAN(1, "한글"),
  ENGLISH(2, "영어"),
  BDD(3, "BDD"),
  ;

  private final int index;
  private final String name;

  Language(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static Language from(int index) {
    return Arrays.stream(Language.values())
        .filter(language -> language.isMatch(index))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 언어는 지원하지 않습니다."));
  }

  private boolean isMatch(int number) {
    return this.index == number;
  }

  @Override
  public String toString() {
    return "%d. %s".formatted(index, name);
  }
}
