package bdd.config;

import bdd.controller.DictionaryController;
import bdd.domain.dao.MemberJpaRepository;
import bdd.domain.dao.MemberRepository;
import bdd.view.DictionaryConsoleView;
import bdd.view.DictionaryView;
import jakarta.persistence.Persistence;

public class DictionaryConfig {

  private static final String PERSISTENCE_UNIT_NAME = "BDD";

  public static DictionaryController dictionaryController() {
    return new DictionaryController(dictionaryView(), memberRepository());
  }

  public static DictionaryView dictionaryView() {
    return new DictionaryConsoleView();
  }

  public static MemberRepository memberRepository() {
    return new MemberJpaRepository(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
  }
}
