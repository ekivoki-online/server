package org.bords.ekivoki.domain;

import lombok.Value;

@Value
public class EkivokiCard implements Card {
    private Side blue;
    private Side yellow;
}
