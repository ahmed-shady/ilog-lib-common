package com.ilog.lib.common.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class KafkaNotification {

    @Builder.Default
    private List<String> tokens = new ArrayList<>();

    @Builder.Default
    private boolean admin = false;

    @Builder.Default
    private List<Long> userIds = new ArrayList<>();

    private String title;
    private String body;
    private Object payload;


}
