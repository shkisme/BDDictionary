package demo;

public class Application {

  public static void main(String[] args) {
    // given
    Member member = new Member();
    Languages languages = new Languages();
    languages.add(new Language("영어"));
    languages.add(new Language("한글"));
    languages.add(new Language("BDD"));
    Dictionary dictionary = new Dictionary();

    // 단어 저장
    member.saveWord("apple", "사과", languages.chose("영어"), dictionary);

    // 단어 조회
    String result = member.search("apple", languages.chose("영어"), dictionary);

    System.out.println(result);
  }
}
