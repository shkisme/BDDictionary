package bdd.view;

import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;

public interface DictionaryView {

  MemberSelectType readMemberSelectType();

  SignInRequestDto readSignInRequest();

  SignUpRequestDto readSignUpRequest();

  DictionarySelectType readDictionaryType();

  void printMessage(String message);
}
