package bdd.view;

import bdd.domain.MemberSelectType;
import java.util.Scanner;
import java.util.function.Supplier;

public class DictionaryConsoleView implements DictionaryView {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public MemberSelectType readMemberSelectType() {
    System.out.println("안녕하세요! BDDictionary 입니다. 어떤 회원으로 이용하시겠어요?");
    System.out.println();
    System.out.println("1. 비회원");
    System.out.println("2. BDD 회원");
    System.out.println("3. 회원 가입");
    return tryGetUserInput(() -> {
      int number = Integer.parseInt(scanner.nextLine());
      return MemberSelectType.from(number);
    });
  }

  private <T> T tryGetUserInput(Supplier<T> inputFunction) {
    while (true) {
      try {
        return inputFunction.get();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
