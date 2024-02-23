package bdd.service;

import bdd.domain.dao.WordRepository;
import java.util.regex.Pattern;

public class EnglishDictionary extends Dictionary {

  public EnglishDictionary(WordRepository wordRepository) {
    super(wordRepository);
  }

  @Override
  protected void validateWord(String wordName) {
    if (!Pattern.matches("^[a-zA-Z]*$", wordName)) {
      throw new IllegalArgumentException("영어 단어를 입력해주세요.");
    }
  }
}
