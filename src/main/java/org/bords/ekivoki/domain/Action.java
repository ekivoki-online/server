package org.bords.ekivoki.domain;

import lombok.Getter;

@Getter
public enum Action {
    WORDS("Слова"),
    REVERSE("Наоборот"),
    DRAWING("Рисунок"),
    GESTURES("Жесты"),
    YES_NO("Да/Нет");

    public static Action byNumber(int number) {
        switch (number) {
            case 0:
                return WORDS;
            case 1:
                return REVERSE;
            case 2:
                return DRAWING;
            case 3:
                return GESTURES;
            case 4:
                return YES_NO;
            default:
                throw new IllegalArgumentException("number must be in range [0,5]");
        }
    }

    private final String type;

    Action(String type) {
        this.type = type;
    }
}
