package com.ilog.lib.common.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class Notification {

    private List<String> tokens;
    private boolean admin;
    private List<Long> userIds;
    String title;
    String body;
    Object payload;


}
