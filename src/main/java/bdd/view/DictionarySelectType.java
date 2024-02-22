package bdd.view;

import java.util.Arrays;

public enum DictionarySelectType {
  KOREAN_TO_ENGLISH_DICTIONARY(1, "한영사전"),
  ENGLISH_TO_KOREAN_DICTIONARY(2, "영한사전"),
  BDD_DICTIONARY(3, "BDD 사전"),
  END(4, "종료"),
  ;

  private final int index;
  private final String name;

  DictionarySelectType(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static DictionarySelectType from(int index) {
    return Arrays.stream(DictionarySelectType.values())
        .filter(dictionarySelectType -> dictionarySelectType.isMatch(index))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 사전 타입은 없습니다."));
  }

  private boolean isMatch(int number) {
    return this.index == number;
  }

  @Override
  public String toString() {
    return "%d. %s".formatted(index, name);
  }
}
