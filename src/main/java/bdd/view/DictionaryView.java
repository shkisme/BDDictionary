package bdd.view;

import bdd.domain.dao.Language;

public interface DictionaryView {

  SelectType readMemberSelectType();

  String readWord();

  String readMean();

  Language readLanguageType();

  void printMessage(String message);
}
