package bdd.view;

import java.util.Arrays;

public enum SelectType {
  REGISTRATION(1, "단어 등록하기"),
  SEARCH(2, "단어 검색하기"),
  FIND_ALL(3, "등록된 모든 단어 조회하기"),
  ;

  private final int index;
  private final String name;

  SelectType(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static SelectType from(int index) {
    return Arrays.stream(SelectType.values())
        .filter(type -> type.isMatch(index))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("%d번의 기능은 없습니다.".formatted(index)));
  }

  private boolean isMatch(int number) {
    return this.index == number;
  }

  @Override
  public String toString() {
    return "%d. %s".formatted(index, name);
  }
}
