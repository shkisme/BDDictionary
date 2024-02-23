package bdd.controller;

import static bdd.view.DictionarySelectType.END;

import bdd.domain.dictionary.dao.BDDWordMemoryRepository;
import bdd.domain.dictionary.dao.WordMemoryRepository;
import bdd.service.BDDictionary;
import bdd.service.DictionaryService;
import bdd.service.EnglishToKoreanDictionary;
import bdd.service.KoreanToEnglishDictionary;
import bdd.view.DictionarySelectType;
import bdd.view.DictionaryView;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final DictionaryService dictionaryService;

  public DictionaryController(
      DictionaryView dictionaryView,
      DictionaryService dictionaryService
  ) {
    this.dictionaryView = dictionaryView;
    this.dictionaryService = dictionaryService;
  }

  public void run() {
    dictionaryView.printMessage("안녕하세요! BDDictionary 입니다.");
    while (true) {
      try {
        DictionarySelectType dictionarySelectType = useDictionary();
        if (dictionarySelectType == END) {
          break;
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private DictionarySelectType useDictionary() {
    DictionarySelectType dictionarySelectType = dictionaryView.readDictionaryType();
    switch (dictionarySelectType) {
      case KOREAN_TO_ENGLISH_DICTIONARY ->
          dictionaryService.start(new KoreanToEnglishDictionary(new WordMemoryRepository()));
      case ENGLISH_TO_KOREAN_DICTIONARY ->
          dictionaryService.start(new EnglishToKoreanDictionary(new WordMemoryRepository()));
      case BDD_DICTIONARY -> {
        dictionaryService.start(new BDDictionary(new BDDWordMemoryRepository()));
      }
    }
    return dictionarySelectType;
  }
}
