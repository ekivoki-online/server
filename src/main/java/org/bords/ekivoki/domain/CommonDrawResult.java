package org.bords.ekivoki.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value(staticConstructor = "of")
public class CommonDrawResult implements DrawResult {

    @JsonProperty
    String action;

    @JsonProperty
    String word;

    @JsonProperty
    String theme;

    @Override
    @JsonProperty
    public DrawType type() {
        return DrawType.COMMON;
    }
}
