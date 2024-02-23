package bdd.service;

import bdd.domain.dictionary.dao.WordRepository;

public class BDDictionary implements Dictionary {

  private final WordRepository wordRepository;

  public BDDictionary(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }
}
