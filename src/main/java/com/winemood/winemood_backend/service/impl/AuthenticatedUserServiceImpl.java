package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.constants.ExceptionMessageConstant;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.exceptions.UserNotFoundException;
import com.winemood.winemood_backend.repository.UserRepository;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticatedUserServiceImpl implements AuthenticatedUserService {
    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {

            throw new UserNotFoundException(
                    ExceptionMessageConstant.USER_NOT_FOUND
            );
        }

        return userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() ->
                        new UserNotFoundException(
                                ExceptionMessageConstant.USER_NOT_FOUND
                        ));
    }

    @Override
    public User getCurrentUserOrNull() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            return null;
        }

        return userRepository.findByEmail(userDetails.getUsername())
                .orElse(null);
    }
}
