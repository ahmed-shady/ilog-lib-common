package com.ilog.lib.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private boolean emailVerified;

    private boolean suspended;
    private LocalDateTime updatedAt;


}
