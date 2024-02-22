package bdd.controller;

import static bdd.domain.MemberSelectType.JOIN_MEMBER;
import static bdd.domain.MemberSelectType.MEMBER;

import bdd.domain.MemberSelectType;
import bdd.view.DictionaryView;
import bdd.domain.dao.MemberRepository;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final MemberRepository memberRepository;

  public DictionaryController(DictionaryView dictionaryView, MemberRepository memberRepository) {
    this.dictionaryView = dictionaryView;
    this.memberRepository = memberRepository;
  }

  public void run() {
    MemberSelectType memberSelectType = dictionaryView.readMemberSelectType();

    if (memberSelectType == MEMBER) {
      validatedMember();
    } else if (memberSelectType == JOIN_MEMBER) {

    }
  }

  private void validatedMember() {
    
  }
}
