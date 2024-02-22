package bdd.service;

import bdd.domain.Member;
import bdd.domain.dao.MemberRepository;
import java.util.Optional;

public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void login(String loginId, String password) {
    Member member = memberRepository.findByLoginId(loginId)
        .orElseThrow(IllegalArgumentException::new);
    if (!member.isMatch(password)) {
      throw new IllegalArgumentException("비밀번호 불일치");
    }
  }

  public void create(String loginId, String password) {
    Optional<Member> existingMember = memberRepository.findByLoginId(loginId);
    if (existingMember.isPresent()) {
      throw new RuntimeException("Member with loginId " + loginId + " already exists");
    }
    // TODO : 회원 저장
  }
}
