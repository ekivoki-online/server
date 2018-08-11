package org.bords.ekivoki.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class Side {

    String title;

    String description;

    List<String> words;
}
