package org.bords.ekivoki.service;

import lombok.AllArgsConstructor;
import org.bords.ekivoki.domain.EkivokiCard;
import org.bords.ekivoki.domain.Side;
import org.bords.ekivoki.repository.EkivokiCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EkivokiCardService {

    private final RandomService randomService;
    private final EkivokiCardRepository repository;

    public Side drawSide() {
        final List<EkivokiCard> desk = repository.findAll();
        final int cardIndex = randomService.randomInt(desk.size());
        final EkivokiCard card = desk.get(cardIndex);

        final int sideIndex = randomService.randomInt(2);
        return (sideIndex == 0) ? card.blue() : card.yellow();
    }
}
