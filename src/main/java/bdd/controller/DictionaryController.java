package bdd.controller;

import bdd.domain.Language;
import bdd.domain.Word;
import bdd.domain.dao.WordRepository;
import bdd.service.BDDictionary;
import bdd.service.DictionaryService;
import bdd.service.EnglishDictionary;
import bdd.service.KoreanDictionary;
import bdd.view.DictionaryView;
import bdd.view.SelectType;
import java.util.List;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final DictionaryService dictionaryService;
  private final WordRepository wordRepository;

  public DictionaryController(
      DictionaryView dictionaryView,
      DictionaryService dictionaryService,
      WordRepository wordRepository
  ) {
    this.dictionaryView = dictionaryView;
    this.dictionaryService = dictionaryService;
    this.wordRepository = wordRepository;
  }

  public void run() {
    dictionaryView.printMessage("안녕하세요! BDDictionary 입니다.");
    while (true) {
      try {
        SelectType selectType = askSelect();
        switch (selectType) {
          case REGISTRATION -> registWord();
          case SEARCH -> searchDictionary();
          case FIND_ALL -> findAllDictionary();
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private SelectType askSelect() {
    return dictionaryView.readMemberSelectType();
  }

  private void registWord() {
    String word = dictionaryView.readWord();
    Language language = dictionaryView.readLanguageType();
    String mean = dictionaryView.readMean();
    switch (language) {
      case KOREAN -> dictionaryService.save(new KoreanDictionary(wordRepository), word, mean, language);
      case ENGLISH -> dictionaryService.save(new EnglishDictionary(wordRepository), word, mean, language);
      case BDD -> dictionaryService.save(new BDDictionary(wordRepository), word, mean, language);
    }
  }

  private void searchDictionary() {
    String word = dictionaryView.readWord();
    Language language = dictionaryView.readLanguageType();
    switch (language) {
      case KOREAN -> System.out.println(
          dictionaryService.search(new KoreanDictionary(wordRepository), word, language)
      );
      case ENGLISH -> System.out.println(
          dictionaryService.search(new EnglishDictionary(wordRepository), word, language)
      );
      case BDD -> System.out.println(
          dictionaryService.search(new BDDictionary(wordRepository), word, language)
      );
    }
  }

  private void findAllDictionary() {
    List<Word> words = wordRepository.findAll();
  }
}
