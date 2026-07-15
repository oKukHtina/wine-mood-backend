package com.winemood.winemood_backend.security;

import com.winemood.winemood_backend.constants.ExceptionMessageConstant;
import com.winemood.winemood_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(ExceptionMessageConstant.USER_BY_EMAIL_NOT_FOUND)
        );
    }
}
