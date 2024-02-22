package bdd.controller;

import static bdd.domain.MemberSelectType.JOIN_MEMBER;
import static bdd.domain.MemberSelectType.MEMBER;

import bdd.domain.MemberSelectType;
import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;
import bdd.service.MemberService;
import bdd.view.DictionaryView;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final MemberService memberService;

  public DictionaryController(DictionaryView dictionaryView, MemberService memberService) {
    this.dictionaryView = dictionaryView;
    this.memberService = memberService;
  }

  public void run() {
    MemberSelectType memberSelectType = dictionaryView.readMemberSelectType();

    if (memberSelectType == MEMBER) {
      login();
    } else if (memberSelectType == JOIN_MEMBER) {
      createMember();
    }
  }

  private void login() {
    SignInRequestDto signInRequestDto = dictionaryView.readSignInRequest();
    memberService.login(signInRequestDto.loginId(), signInRequestDto.password());
  }

  private void createMember() {
    SignUpRequestDto signUpRequestDto = dictionaryView.readSignUpRequest();
    memberService.create(signUpRequestDto.loginId(), signUpRequestDto.password());
  }
}
