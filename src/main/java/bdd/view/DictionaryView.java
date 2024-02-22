package bdd.view;

import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;

public interface DictionaryView {

  void printHelloMessage();

  MemberSelectType readMemberSelectType();

  SignInRequestDto readSignInRequest();

  SignUpRequestDto readSignUpRequest();

  DictionarySelectType readDictionaryType();
}
