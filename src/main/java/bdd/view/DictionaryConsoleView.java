package bdd.view;

import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class DictionaryConsoleView implements DictionaryView {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public MemberSelectType readMemberSelectType() {
    System.out.println("어떤 회원으로 이용하시겠어요?");
    System.out.println();
    Arrays.stream(MemberSelectType.values())
        .forEach(System.out::println);
    return tryGetUserInput(() -> {
      int number = Integer.parseInt(scanner.nextLine());
      return MemberSelectType.from(number);
    });
  }

  @Override
  public SignInRequestDto readSignInRequest() {
    System.out.println("-로그인-");
    System.out.println();
    System.out.println("ID를 입력해주세요.");
    String loginId = tryGetUserInput(scanner::nextLine);
    System.out.println("PW를 입력해주세요.");
    String password = tryGetUserInput(scanner::nextLine);
    return new SignInRequestDto(loginId, password);
  }

  @Override
  public SignUpRequestDto readSignUpRequest() {
    System.out.println("-회원가입-");
    System.out.println();
    System.out.println("ID를 입력해주세요.");
    String loginId = tryGetUserInput(scanner::nextLine);
    System.out.println("PW를 입력해주세요.");
    String password = tryGetUserInput(scanner::nextLine);
    while (true) {
      System.out.println("PW를 다시 한번 입력해주세요.");
      String checkPassword = tryGetUserInput(scanner::nextLine);
      if (password.equals(checkPassword)) {
        break;
      }
    }
    return new SignUpRequestDto(loginId, password);
  }

  @Override
  public DictionarySelectType readDictionaryType() {
    System.out.println("이용하실 기능을 선택해주세요.");
    System.out.println();
    Arrays.stream(DictionarySelectType.values())
        .forEach(System.out::println);
    return tryGetUserInput(() -> {
      int number = Integer.parseInt(scanner.nextLine());
      return DictionarySelectType.from(number);
    });
  }

  @Override
  public void printMessage(String message) {
    System.out.println(message);
  }

  private static <T> T tryGetUserInput(Supplier<T> inputFunction) {
    while (true) {
      try {
        return inputFunction.get();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
