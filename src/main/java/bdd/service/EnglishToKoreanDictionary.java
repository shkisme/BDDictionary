package bdd.service;

import bdd.domain.dictionary.dao.WordRepository;

public class EnglishToKoreanDictionary implements Dictionary {

  private final WordRepository wordRepository;

  public EnglishToKoreanDictionary(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }
}
