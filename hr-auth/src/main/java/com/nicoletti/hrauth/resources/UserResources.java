package com.nicoletti.hrauth.resources;

import com.nicoletti.hrauth.dto.UserDTO;
import com.nicoletti.hrauth.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserResources {

    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<UserDTO> findUser(@RequestParam String email) {
        try {
            UserDTO dto = userService.findUserByEmail(email);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
