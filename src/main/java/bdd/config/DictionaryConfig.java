package bdd.config;

import bdd.controller.DictionaryController;
import bdd.service.DictionaryService;
import bdd.view.DictionaryConsoleView;
import bdd.view.DictionaryView;

public class DictionaryConfig {

  public static DictionaryController dictionaryController() {
    return new DictionaryController(
        dictionaryView(),
        dictionaryService()
    );
  }

  public static DictionaryView dictionaryView() {
    return new DictionaryConsoleView();
  }

  public static DictionaryService dictionaryService() {
    return new DictionaryService();
  }
}
