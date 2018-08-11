package org.bords.ekivoki.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class RandomServiceDefault implements RandomService {

    Random random;

    @Override
    public int randomInt(int bound) {
        return random.nextInt(bound);
    }
}
