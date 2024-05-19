package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserRoleProjection implements Serializable {
    private Integer userId;
    private Integer roleId;
    private String username;
    private String password;
    private String roleName;
}
