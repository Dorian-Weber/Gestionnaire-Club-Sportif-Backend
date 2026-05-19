package com.mns.cda.filsrouge.security;

import com.mns.cda.filsrouge.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
public class AppUserDetails implements UserDetails {


    protected AppUser user ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getAccountType().getAccountTypeName()));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getAppUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getAppUserEmail();
    }
}
