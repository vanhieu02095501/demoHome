package com.fsofter.home.model;

import lombok.*;


public class User {
    private String username;  // Là email (unique)
    private String password;
    private String role;      // ROLE_ADMIN, ROLE_USER
}
