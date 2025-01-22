package com.harshit.backend.request;

import lombok.Data;

public class RoleBasedRequest {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
