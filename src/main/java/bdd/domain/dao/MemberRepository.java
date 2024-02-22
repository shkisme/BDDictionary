package bdd.domain.dao;

import bdd.domain.Member;
import java.util.Optional;

public interface MemberRepository {

  Optional<Member> findByLoginId(String loginId);
}
