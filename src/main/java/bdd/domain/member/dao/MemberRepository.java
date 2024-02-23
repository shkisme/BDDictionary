package bdd.domain.member.dao;

import bdd.domain.member.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

  Optional<Member> findByLoginId(String loginId);

  Member save(Member member);

  List<Member> findAll();
}
