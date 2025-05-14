package com.nicoletti.hrauth.dto;

import java.util.Set;

public record UserDTO(Long id, String name, String email, String password, Set<RoleDTO> roles){
}
