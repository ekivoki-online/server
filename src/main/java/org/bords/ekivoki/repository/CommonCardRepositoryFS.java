package org.bords.ekivoki.repository;

import org.bords.ekivoki.domain.CommonCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonCardRepositoryFS implements CommonCardRepository {

    private final String fileLocation;
    private final FileSystemStorage fileSystemStorage;

    @Autowired
    public CommonCardRepositoryFS(
            @Value("${ekivoki.common-cards.location}") String fileLocation,
            FileSystemStorage fileSystemStorage
    ) {
        this.fileLocation = fileLocation;
        this.fileSystemStorage = fileSystemStorage;
    }

    @Override
    @Cacheable("common-cards")
    public List<CommonCard> findAll() {
        return fileSystemStorage.findAll(fileLocation, CommonCard.class);
    }
}
