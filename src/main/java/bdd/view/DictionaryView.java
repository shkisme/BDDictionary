package bdd.view;

import bdd.domain.Language;

public interface DictionaryView {

  SelectType readMemberSelectType();

  String readWord();

  String readMean();

  Language readLanguageType();

  void printMessage(String message);
}
