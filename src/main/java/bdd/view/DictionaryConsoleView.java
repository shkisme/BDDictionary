package bdd.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class DictionaryConsoleView implements DictionaryView {

  private static final Scanner scanner = new Scanner(System.in);

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
