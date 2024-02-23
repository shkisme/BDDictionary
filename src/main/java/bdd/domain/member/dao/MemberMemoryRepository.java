package bdd.domain.member.dao;

import static java.util.Collections.unmodifiableList;

import bdd.domain.member.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberMemoryRepository implements MemberRepository {

  private final List<Member> members = new ArrayList<>();

  @Override
  public Optional<Member> findByLoginId(String loginId) {
    return members.stream()
        .filter(member -> member.isSameLoginId(loginId))
        .findFirst();
  }

  @Override
  public Member save(Member member) {
    members.add(member);
    return member;
  }

  @Override
  public List<Member> findAll() {
    return unmodifiableList(members);
  }
}
