package com.study.notepad.user.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
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

    return queryFactory.selectFrom(user).where(firstNameEq(firstName)).fetch();
//    return queryFactory.selectFrom(user).where(firstNameEq(firstName), lastNameEq(lastName)).fetch();
  }

  private BooleanExpression lastNameEq(String lastName) {
    return lastName != null ? QUser.user.lastName.eq(lastName) : null;
  }

  private BooleanExpression firstNameEq(String firstName) {
    return firstName != null ? QUser.user.firstName.eq(firstName) : null;
  }
}
