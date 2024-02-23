package demo;

public class Member {

  public void saveWord(String word, String mean, Language language, Dictionary dictionary) {
    dictionary.create(word, mean, language);
  }

  public String search(String word, Language language, Dictionary dictionary) {
    return dictionary.convert(word, language);
  }
}
