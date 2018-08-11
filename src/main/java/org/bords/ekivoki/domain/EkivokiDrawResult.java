package org.bords.ekivoki.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class EkivokiDrawResult implements DrawResult {

    @JsonProperty
    String title;

    @JsonProperty
    String description;

    @JsonProperty
    List<String> words;

    public static EkivokiDrawResult ofSide(Side side) {
        return EkivokiDrawResult.of(
                side.title(),
                side.description(),
                side.words()
        );
    }

    @Override
    @JsonProperty
    public DrawType type() {
        return DrawType.EKIVOKI;
    }
}
