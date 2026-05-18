package com.mns.cda.filsrouge.security;

import com.mns.cda.filsrouge.dao.AppUserDAO;
import com.mns.cda.filsrouge.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    protected final AppUserDAO appUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = appUserDao.findByAppUserEmail(email);

        if(optionalAppUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new AppUserDetails(optionalAppUser.get());
    }
}
