package org.bords.ekivoki.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.AllArgsConstructor;
import org.bords.ekivoki.exception.StorageException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

@AllArgsConstructor
@Repository
public class FileSystemStorage {

    ObjectMapper objectMapper;

    public <T> List<T> findAll(String fileLocation, Class<T> clazz) throws StorageException {
        try {
            final File file = new ClassPathResource(fileLocation)
                    .getFile();

            final TypeFactory typeFactory = objectMapper.getTypeFactory();
            return objectMapper.readValue(
                    file,
                    typeFactory.constructCollectionType(List.class, clazz)
            );
        } catch (Exception e) {
            throw new StorageException(
                    MessageFormat.format("Cannot load {0} from {1}", clazz.getName(), fileLocation),
                    e
            );
        }
    }
}
