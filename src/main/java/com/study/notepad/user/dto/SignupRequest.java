package com.study.notepad.user.dto;

import com.study.notepad.user.domain.User.Gender;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SignupRequest {

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String password;

  @NotBlank
  private String firstName;

  @NotBlank
  private String firstNameKana;

  @NotBlank
  private String lastName;

  @NotBlank
  private String lastNameKana;

  @NotBlank
  private String phone;

  @NotBlank
  private String postalCode;

  @NotBlank
  private String prefecture;

  @NotBlank
  private String address1;

  private String address2;

  @NotNull
  private LocalDate birthday;

  @NotNull
  private Gender gender;

  @AssertTrue
  private boolean acceptTerms;
}
