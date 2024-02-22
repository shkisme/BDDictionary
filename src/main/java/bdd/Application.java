package bdd;

import static bdd.config.DictionaryConfig.dictionaryController;

import bdd.controller.DictionaryController;

public class Application {

  public static void main(String[] args) {
    DictionaryController dictionaryController = dictionaryController();
    dictionaryController.run();
  }
}
