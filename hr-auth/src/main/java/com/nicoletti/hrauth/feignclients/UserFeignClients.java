package com.nicoletti.hrauth.feignclients;

import com.nicoletti.hrauth.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClients {

    @GetMapping("/search")
    ResponseEntity<UserDTO> findByEmail(@RequestParam String email);

}
