package com.ilog.lib.common.model;



import com.ilog.lib.common.constant.ResourceType;
import com.ilog.lib.common.constant.ShareSetting;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaNewsFeed extends KafkaBaseMessage {

    private ResourceType resourceType;

    private Long resourceId;

    private ShareSetting shareSetting;

    private String data;

    private Long doctorId;

    private Long consultantId;


    private Instant createdAt;


    private Instant updatedAt;



    private Long createdById;


    private Long updatedById;

}
