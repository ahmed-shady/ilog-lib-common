package com.ilog.lib.common.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilog.lib.common.constant.KafkaOperation;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaMessage<T> {
    KafkaOperation operation;
    T body;
}
