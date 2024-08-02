package com.ilog.lib.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilog.lib.common.constant.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentUser {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private Boolean emailVerified;
    private Boolean suspended;
    private LocalDateTime updatedAt;

    public boolean isAdmin(){
        return role.equals(Role.ADMIN) || role.equals(Role.SUPER_ADMIN);
    }

}
