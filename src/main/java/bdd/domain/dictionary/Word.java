package bdd.domain.dictionary;

public class Word {

  private final String key;

  private final String value;

  private final WordType wordType;

  public Word(String key, String value, WordType wordType) {
    this.key = key;
    this.value = value;
    this.wordType = wordType;
  }
}
