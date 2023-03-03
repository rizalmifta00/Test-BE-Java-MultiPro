package com.test.backend.Security.Service;

import com.test.backend.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLooked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private Set<GrantedAuthority> authorityList;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    public UserDetailsImpl(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isAccountNonExpired = true;
        this.isAccountNonLooked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLooked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
