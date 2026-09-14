package com.antebantez.shopptracker.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record RegisterRequest(
        @NotEmpty
        @Email
        String email,

        @NotEmpty
        @Length(min = 8, max = 72)
        String password

) {
}
