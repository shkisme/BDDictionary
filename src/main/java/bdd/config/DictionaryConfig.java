package bdd.config;

import bdd.controller.DictionaryController;
import bdd.domain.member.dao.MemberMemoryRepository;
import bdd.domain.member.dao.MemberRepository;
import bdd.service.DictionaryService;
import bdd.service.MemberService;
import bdd.view.DictionaryConsoleView;
import bdd.view.DictionaryView;

public class DictionaryConfig {

  public static DictionaryController dictionaryController() {
    return new DictionaryController(
        dictionaryView(),
        memberService(),
        dictionaryService()
    );
  }

  public static DictionaryView dictionaryView() {
    return new DictionaryConsoleView();
  }

  public static MemberService memberService() {
    return new MemberService(memberRepository());
  }

  public static MemberRepository memberRepository() {
    return new MemberMemoryRepository();
  }

  public static DictionaryService dictionaryService() {
    return new DictionaryService();
  }
}
