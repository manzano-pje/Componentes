package com.pjem.login.record;

import com.pjem.login.identitie.Roles;

public record UserDto(
        int id,
        String email,
        String password,
        Roles role) {
}
