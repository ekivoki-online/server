package org.bords.ekivoki.service;

import lombok.AllArgsConstructor;
import org.bords.ekivoki.domain.CommonCard;
import org.bords.ekivoki.domain.WordAndTheme;
import org.bords.ekivoki.repository.CommonCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommonCardService {

    CommonCardRepository repository;
    RandomService randomService;

    public WordAndTheme drawWord(int wordNumber) {
        final List<CommonCard> desk = repository.findAll();
        final int cardIndex = randomService.randomInt(desk.size());
        final CommonCard card = desk.get(cardIndex);
        final int colorIndex = randomService.randomInt(2);

        final List<String> words = (colorIndex == 0) ? card.yellowWords() : card.blueWords();
        final String word = words.get(wordNumber);

        return WordAndTheme.of(word, card.theme());
    }
}
