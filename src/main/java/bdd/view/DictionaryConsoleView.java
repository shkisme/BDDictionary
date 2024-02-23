package bdd.view;

import bdd.domain.Language;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class DictionaryConsoleView implements DictionaryView {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public SelectType readMemberSelectType() {
    System.out.println("이용하실 기능을 선택해주세요.");
    System.out.println();
    Arrays.stream(SelectType.values())
        .forEach(System.out::println);
    return tryGetUserInput(() -> {
      int number = Integer.parseInt(scanner.nextLine());
      return SelectType.from(number);
    });
  }

  @Override
  public String readWord() {
    System.out.print("단어를 입력해주세요 : ");
    return tryGetUserInput(scanner::nextLine);
  }

  @Override
  public String readMean() {
    System.out.print("대응하는 단어를 입력해주세요 : ");
    return tryGetUserInput(scanner::nextLine);
  }

  @Override
  public Language readLanguageType() {
    System.out.println("대응하는 (혹은 찾으실) 언어를 선택해주세요.");
    System.out.println();
    Arrays.stream(Language.values())
        .forEach(System.out::println);
    return tryGetUserInput(() -> {
      int number = Integer.parseInt(scanner.nextLine());
      return Language.from(number);
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
