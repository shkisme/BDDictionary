package bdd.view;

import bdd.domain.MemberSelectType;
import bdd.dto.SignInRequestDto;
import bdd.dto.SignUpRequestDto;

public interface DictionaryView {

  MemberSelectType readMemberSelectType();

  SignInRequestDto readSignInRequest();

  SignUpRequestDto readSignUpRequest();
}
