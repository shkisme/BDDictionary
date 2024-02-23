package bdd.model;

public class Member {

  public void saveWord(String word, String mean, Language language, Dictionary dictionary) {
    dictionary.create(word, mean, language);
  }
}
