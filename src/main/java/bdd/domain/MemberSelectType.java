package bdd.domain;

import java.util.Arrays;

public enum MemberSelectType {
  NON_MEMBER(1),
  MEMBER(2),
  JOIN_MEMBER(3),
  ;

  private final int number;

  MemberSelectType(int number) {
    this.number = number;
  }

  public static MemberSelectType from(int number) {
    return Arrays.stream(MemberSelectType.values())
        .filter(memberSelectType -> memberSelectType.isMatch(number))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  private boolean isMatch(int number) {
    return this.number == number;
  }
}
