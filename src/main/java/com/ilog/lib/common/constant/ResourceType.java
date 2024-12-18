package com.ilog.lib.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResourceType {
    ACTIVITY("%s/activities/%s"), USER("%s/profile/%s"),
    CERTIFICATE("%s/certificates/%s"),
    DOCUMENT("%s/documents/%s");

    private String pathFormat;


}
