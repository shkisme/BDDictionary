package bdd.domain.member.dao;

import bdd.domain.member.Member;
import java.util.Optional;

public interface MemberRepository {

  Optional<Member> findByLoginId(String loginId);

  void save(Member member);
}