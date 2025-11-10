package com.ewersson.products.entities.dto;

import com.ewersson.products.entities.role.UserRole;

public record RegisterDTO(String login, String password, UserRole role){}
