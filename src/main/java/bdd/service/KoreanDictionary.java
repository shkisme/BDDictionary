package bdd.service;

import bdd.domain.dao.WordRepository;
import java.util.regex.Pattern;

public class KoreanDictionary extends Dictionary {

  public KoreanDictionary(WordRepository wordRepository) {
    super(wordRepository);
  }

  @Override
  protected void validateWord(String wordName) {
    if (!Pattern.matches("^[가-힣]*$", wordName)) {
      throw new IllegalArgumentException("한글 단어를 입력해주세요.");
    }
  }
}
