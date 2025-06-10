package com.study.notepad.user.service;

import com.study.notepad.user.domain.User;
import com.study.notepad.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserInfoById(Long userId) {
    return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not exist"));
  }

  public User getUserInfoByEmail(String email) {
    return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not exist"));
  }
}
