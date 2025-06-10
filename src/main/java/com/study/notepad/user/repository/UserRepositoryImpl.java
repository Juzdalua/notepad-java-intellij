package com.study.notepad.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.notepad.user.domain.QUser;
import com.study.notepad.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  @Override
  public List<User> searchUsersByFirstName(String firstName) {

    QUser user = QUser.user;

    return queryFactory.selectFrom(user).where(firstName != null ? user.firstName.eq(firstName) : null).fetch();
  }
}
