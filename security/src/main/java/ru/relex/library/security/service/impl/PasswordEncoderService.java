package ru.relex.library.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.relex.library.services.service.IPasswordEncoderService;

@Service
public class PasswordEncoderService implements IPasswordEncoderService {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public PasswordEncoderService(final PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encode(final String password) {
    return passwordEncoder.encode(password);
  }
}
