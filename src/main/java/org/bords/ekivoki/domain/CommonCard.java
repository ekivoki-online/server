package org.bords.ekivoki.domain;

import lombok.Value;

import java.util.List;

@Value
public class CommonCard implements Card {
    String theme;
    List<String> blueWords;
    List<String> yellowWords;
}
