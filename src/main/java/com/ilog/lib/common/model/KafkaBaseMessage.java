package com.ilog.lib.common.model;

import com.ilog.lib.common.constant.KafkaOperation;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder(builderMethodName = "kafkaBaseBuilder") // Use SuperBuilder for inheritance
@NoArgsConstructor
@AllArgsConstructor
public class KafkaBaseMessage {
    private KafkaOperation operation;
}
