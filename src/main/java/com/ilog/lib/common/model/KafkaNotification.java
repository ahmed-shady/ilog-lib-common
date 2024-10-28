package com.ilog.lib.common.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class KafkaNotification {

    private List<String> tokens;
    private boolean admin;
    private List<Long> userIds;
    private String title;
    private String body;
    private Object payload;


}
