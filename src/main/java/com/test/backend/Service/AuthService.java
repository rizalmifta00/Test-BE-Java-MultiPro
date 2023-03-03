package com.test.backend.Service;

import com.test.backend.Dto.Auth.RegisterDto;
import com.test.backend.Dto.Auth.UserDto;

public interface AuthService {

    public RegisterDto create(RegisterDto registerDto);

    public UserDto findByUsername(String username);
}
