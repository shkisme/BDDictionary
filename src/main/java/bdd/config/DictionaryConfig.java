package bdd.config;

import bdd.controller.DictionaryController;
import bdd.domain.dao.WordMemoryRepository;
import bdd.domain.dao.WordRepository;
import bdd.service.DictionaryService;
import bdd.view.DictionaryConsoleView;
import bdd.view.DictionaryView;

public class DictionaryConfig {

  public static DictionaryController dictionaryController() {
    return new DictionaryController(
        dictionaryView(),
        dictionaryService(),
        wordRepository()
    );
  }

  public static DictionaryView dictionaryView() {
    return new DictionaryConsoleView();
  }

  public static DictionaryService dictionaryService() {
    return new DictionaryService();
  }

  public static WordRepository wordRepository() {
    return new WordMemoryRepository();
  }
}
