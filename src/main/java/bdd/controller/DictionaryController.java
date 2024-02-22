package bdd.controller;

import static bdd.view.MemberSelectType.NON_MEMBER;

import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;
import bdd.service.MemberService;
import bdd.view.DictionarySelectType;
import bdd.view.DictionaryView;
import bdd.view.MemberSelectType;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final MemberService memberService;

  public DictionaryController(DictionaryView dictionaryView, MemberService memberService) {
    this.dictionaryView = dictionaryView;
    this.memberService = memberService;
  }

  public void run() {
    dictionaryView.printHelloMessage();
    MemberSelectType memberSelectType = loginOrJoin();
    useDictionary(memberSelectType);
  }

  private MemberSelectType loginOrJoin() {
    while (true) {
      MemberSelectType memberSelectType = dictionaryView.readMemberSelectType();
      try {
        switch (memberSelectType) {
          case MEMBER -> login();
          case JOIN_MEMBER -> createMember();
        }
        return memberSelectType;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
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

  private void useDictionary(MemberSelectType memberSelectType) {
    while (true) {
      DictionarySelectType dictionarySelectType = dictionaryView.readDictionaryType();
      try {
        switch (dictionarySelectType) {
          case KOREAN_TO_ENGLISH_DICTIONARY -> {
            System.out.println();
          }
          case ENGLISH_TO_KOREAN_DICTIONARY -> {
            System.out.println();
          }
          case BDD_DICTIONARY -> {
            if (memberSelectType == NON_MEMBER) {
              throw new IllegalArgumentException("비회원은 [BDD 사전]에 접근할 권한이 없습니다. 회원 가입을 해주세요.");
            }
            System.out.println();
          }
          case END -> {
            break;
          }
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
