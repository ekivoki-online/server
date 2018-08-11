package org.bords.ekivoki.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class WordAndTheme {
    String word;

    String theme;
}
