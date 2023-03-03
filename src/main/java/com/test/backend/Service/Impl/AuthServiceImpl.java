package com.test.backend.Service.Impl;

import com.test.backend.Dto.Auth.RegisterDto;
import com.test.backend.Dto.Auth.UserDto;
import com.test.backend.Models.User;
import com.test.backend.Repository.UserRepository;
import com.test.backend.Service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public RegisterDto create(RegisterDto registerDto) {
        User user = modelMapper.map(registerDto,User.class);
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        user = userRepository.save(user);
        return modelMapper.map(user,RegisterDto.class);
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException(username + " tidak ditemukan"));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }


}
