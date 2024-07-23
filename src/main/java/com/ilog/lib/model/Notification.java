package com.ilog.lib.model;


import com.ilog.lib.constant.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
public class Notification {

    private Long id;

    String message;

    UserDto user; //optional. Contains: id, name, email, profileImage

    @NotBlank(message = "category is missing")
    String category;

    Role recipientRole;

    Long recipientId;

    LocalDateTime createdAt;

    Boolean read = false;

}
