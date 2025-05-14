package com.nicoletti.hrauth.services;

import com.nicoletti.hrauth.dto.UserDTO;
import com.nicoletti.hrauth.feignclients.UserFeignClients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClients userFeignClients;

    public UserDTO findUserByEmail(String email) {
        UserDTO user = userFeignClients.findByEmail(email).getBody();

        if (user == null) {
            log.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: {}", email);
        return user;
    }

}
