package bdd.view;

import java.util.Arrays;

public enum MemberSelectType {
  NON_MEMBER(1, "비회원"),
  MEMBER(2, "BDD 회원"),
  JOIN_MEMBER(3, "회원 가입"),
  ;

  private final int index;
  private final String name;

  MemberSelectType(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static MemberSelectType from(int index) {
    return Arrays.stream(MemberSelectType.values())
        .filter(memberSelectType -> memberSelectType.isMatch(index))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 회원 타입은 없습니다."));
  }

  private boolean isMatch(int number) {
    return this.index == number;
  }

  @Override
  public String toString() {
    return "%d. %s".formatted(index, name);
  }
}
