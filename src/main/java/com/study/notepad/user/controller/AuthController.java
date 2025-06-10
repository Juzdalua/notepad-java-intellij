package com.study.notepad.user.controller;

import com.study.notepad.common.dto.ApiResponse;
import com.study.notepad.global.util.NumberUtil;
import com.study.notepad.user.dto.LoginRequest;
import com.study.notepad.user.dto.LoginResponse;
import com.study.notepad.user.dto.SignupRequest;
import com.study.notepad.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

  private final AuthService authService;

  @PostMapping("/signup")
  public ResponseEntity<ApiResponse<LoginResponse>> signup(@RequestBody @Valid SignupRequest request) {
    LoginResponse response = authService.signup(request);
    return ResponseEntity.ok(new ApiResponse<>(response));
  }

  @PostMapping("/login")
  public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest request) {
    LoginResponse response = authService.login(request);
    return ResponseEntity.ok(new ApiResponse<>(response));
  }

  @GetMapping("/test")
  public void test(){
    System.out.println(NumberUtil.isNumeric("123"));
    System.out.println(NumberUtil.isNumeric("as"));
    System.out.println(NumberUtil.isNumeric("a1"));
    System.out.println("TEST");
  }
}