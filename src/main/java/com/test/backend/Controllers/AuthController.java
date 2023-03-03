package com.test.backend.Controllers;

import com.test.backend.Dto.Auth.JwtResponseDto;
import com.test.backend.Dto.Auth.LoginDto;
import com.test.backend.Dto.Auth.RegisterDto;
import com.test.backend.Dto.Auth.UserDto;
import com.test.backend.Dto.ResponseDto;
import com.test.backend.Security.Jwt.JwtUtils;
import com.test.backend.Security.Service.UserDetailsServiceImpl;
import com.test.backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> create(@Valid @RequestBody RegisterDto registerDto){
        try{
            RegisterDto user = authService.create(registerDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<JwtResponseDto>> login(@RequestBody LoginDto loginDto){
        UserDto userDto = authService.findByUsername(loginDto.getUsername());
        ResponseDto<JwtResponseDto> responseDto = new ResponseDto<>();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
        String jwtToken = jwtUtils.generateToken(userDetails);

        JwtResponseDto jwtResponse = new JwtResponseDto(jwtToken, userDto.getUsername(),userDto.getId());
        responseDto.setSuccess(true);
        responseDto.setStatus("200");
        responseDto.setMessage("Token for Login");
        responseDto.setData(jwtResponse);

        return ResponseEntity.ok(responseDto);

    }
}
