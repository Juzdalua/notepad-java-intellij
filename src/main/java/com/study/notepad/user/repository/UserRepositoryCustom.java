package com.study.notepad.user.repository;

import com.study.notepad.user.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
   List<User> searchUsersByFirstName(String firstName);
}
