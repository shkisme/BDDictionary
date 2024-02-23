package bdd.service;

import bdd.domain.dao.WordRepository;
import java.util.regex.Pattern;

public class BDDictionary extends Dictionary {

  public BDDictionary(WordRepository wordRepository) {
    super(wordRepository);
  }

  @Override
  protected void validateWord(String wordName) {
    if (!Pattern.matches("^([Bb비])[Dd디]{2}$", wordName)) {
      throw new IllegalArgumentException("BDD 단어를 입력해주세요.");
    }
  }
}
