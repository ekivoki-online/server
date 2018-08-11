package org.bords.ekivoki.service;

import lombok.AllArgsConstructor;
import org.bords.ekivoki.domain.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  DrawServiceDefault implements DrawService {

    private CommonCardService commonCardService;
    private EkivokiCardService ekivokiCardService;

    @Override
    public DrawResult draw(int diceNumber) {
        if(diceNumber == 6) {
            final Side side = ekivokiCardService.drawSide();
            return EkivokiDrawResult.ofSide(side);
        }

        final WordAndTheme wordAndTheme = commonCardService.drawWord(diceNumber - 1);
        final Action action = Action.byNumber(diceNumber - 1);
        return CommonDrawResult.of(
                action.type(),
                wordAndTheme.word(),
                wordAndTheme.theme()
        );
    }

}
