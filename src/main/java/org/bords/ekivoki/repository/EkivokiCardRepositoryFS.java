package org.bords.ekivoki.repository;

import org.bords.ekivoki.domain.EkivokiCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EkivokiCardRepositoryFS implements EkivokiCardRepository {

    private final String fileLocation;
    private final FileSystemStorage fileSystemStorage;

    @Autowired
    public EkivokiCardRepositoryFS(
            @Value("${ekivoki.ekivoki-cards.location}") String fileLocation,
            FileSystemStorage fileSystemStorage
    ) {
        this.fileLocation = fileLocation;
        this.fileSystemStorage = fileSystemStorage;
    }

    @Override
    @Cacheable("ekivoki-cards")
    public List<EkivokiCard> findAll() {
        return fileSystemStorage.findAll(fileLocation, EkivokiCard.class);
    }
}
