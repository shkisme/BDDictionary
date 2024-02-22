package bdd.service;

import bdd.domain.member.Member;
import bdd.domain.member.dao.MemberRepository;
import java.util.Optional;

public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public void login(String loginId, String password) {
    Member member = memberRepository.findByLoginId(loginId)
        .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));
    if (!member.isSamePassword(password)) {
      throw new IllegalArgumentException("비밀번호가 불일치합니다.");
    }
  }

  public void create(String loginId, String password) {
    Optional<Member> existingMember = memberRepository.findByLoginId(loginId);
    if (existingMember.isPresent()) {
      throw new IllegalArgumentException("Member with loginId " + loginId + " already exists");
    }
    memberRepository.save(new Member(loginId, password));
  }
}
