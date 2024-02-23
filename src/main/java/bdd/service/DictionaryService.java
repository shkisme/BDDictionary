package bdd.service;

import bdd.domain.Language;

public class DictionaryService {

  public void save(Dictionary dictionary, String word, String mean, Language language) {
    dictionary.create(word, mean, language);
  }

  public String search(Dictionary dictionary, String word, Language language) {
    return dictionary.convert(word, language);
  }
}
