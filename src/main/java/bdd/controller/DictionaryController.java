package bdd.controller;

import static bdd.view.DictionarySelectType.BDD_DICTIONARY;
import static bdd.view.DictionarySelectType.END;

import bdd.domain.dictionary.dao.BDDWordMemoryRepository;
import bdd.domain.dictionary.dao.WordMemoryRepository;
import bdd.domain.member.Member;
import bdd.domain.member.MemberType;
import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;
import bdd.service.BDDictionary;
import bdd.service.DictionaryService;
import bdd.service.EnglishToKoreanDictionary;
import bdd.service.KoreanToEnglishDictionary;
import bdd.service.MemberService;
import bdd.view.DictionarySelectType;
import bdd.view.DictionaryView;
import bdd.view.MemberSelectType;

public class DictionaryController {

  private final DictionaryView dictionaryView;
  private final MemberService memberService;
  private final DictionaryService dictionaryService;

  public DictionaryController(
      DictionaryView dictionaryView,
      MemberService memberService,
      DictionaryService dictionaryService
  ) {
    this.dictionaryView = dictionaryView;
    this.memberService = memberService;
    this.dictionaryService = dictionaryService;
  }

  public void run() {
    dictionaryView.printMessage("안녕하세요! BDDictionary 입니다.");
    while (true) {
      try {
        Member member = loginOrJoin();
        DictionarySelectType dictionarySelectType = useDictionary(member);
        if (dictionarySelectType == END) {
          break;
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private Member loginOrJoin() {
    MemberSelectType memberSelectType = dictionaryView.readMemberSelectType();
    switch (memberSelectType) {
      case MEMBER -> {
        return login();
      }
      case JOIN_MEMBER -> {
        return createMember();
      }
    }
    return new Member(MemberType.NON_MEMBER);
  }

  private Member login() {
    SignInRequestDto signInRequestDto = dictionaryView.readSignInRequest();
    return memberService.login(signInRequestDto.loginId(), signInRequestDto.password());
  }

  private Member createMember() {
    SignUpRequestDto signUpRequestDto = dictionaryView.readSignUpRequest();
    Member member = memberService.create(signUpRequestDto.loginId(), signUpRequestDto.password());
    dictionaryView.printMessage("회원 가입 되었습니다.");
    return member;
  }

  private DictionarySelectType useDictionary(Member member) {
    DictionarySelectType dictionarySelectType = dictionaryView.readDictionaryType();
    switch (dictionarySelectType) {
      case KOREAN_TO_ENGLISH_DICTIONARY ->
          dictionaryService.start(new KoreanToEnglishDictionary(new WordMemoryRepository()));
      case ENGLISH_TO_KOREAN_DICTIONARY ->
          dictionaryService.start(new EnglishToKoreanDictionary(new WordMemoryRepository()));
      case BDD_DICTIONARY -> {
        if (member.isNonMember()) {
          throw new IllegalArgumentException(
              "비회원은 [%s]에 접근할 권한이 없습니다. 회원 가입을 해주세요.".formatted(BDD_DICTIONARY.getName())
          );
        }
        dictionaryService.start(new BDDictionary(new BDDWordMemoryRepository()));
      }
    }
    return dictionarySelectType;
  }
}
