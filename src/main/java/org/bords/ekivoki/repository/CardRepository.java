package org.bords.ekivoki.repository;

import org.bords.ekivoki.domain.Card;

import java.util.List;

public interface CardRepository<T extends Card> {
    List<T> findAll();
}
