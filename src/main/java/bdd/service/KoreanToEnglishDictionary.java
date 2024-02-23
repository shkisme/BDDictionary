package bdd.service;

import bdd.domain.dictionary.dao.WordRepository;

public class KoreanToEnglishDictionary implements Dictionary {

  private final WordRepository wordRepository;

  public KoreanToEnglishDictionary(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

}
