package com.study.notepad.user.controller;

import com.study.notepad.common.dto.ApiResponse;
import com.study.notepad.user.domain.User;
import com.study.notepad.user.dto.UserResponse;
import com.study.notepad.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<ApiResponse<UserResponse>> getMyInfo(Authentication authentication) {
    // JwtAuthenticationFilter -> doFilterInternal() -> userService.getUserInfoById()
    User user = (User) authentication.getPrincipal();

    return ResponseEntity.ok(new ApiResponse<>(UserResponse.of(user)));
  }

  @GetMapping("/search")
  public ResponseEntity<ApiResponse<List<UserResponse>>> searchUserByFirstName(@RequestParam(required = false) String firstName) {

    List<User> users = userService.searchUsersByFirstName(firstName);
    List<UserResponse> responseList = users.stream().map(UserResponse::of).toList();
    return ResponseEntity.ok(new ApiResponse<>(responseList));
  }
}
