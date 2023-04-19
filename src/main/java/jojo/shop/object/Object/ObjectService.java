package jojo.shop.object.Object;

import jojo.shop.object.Dto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ObjectService {
    private final ObjectRepository objectRepository;
    private final ObjectMapper objectMapper;
    public void saveNewObject(Dto.ObjectInput dto) {
        if (objectRepository.findByName(dto.getName()).isPresent()) {
            throw new ResponseStatusException(409,
                    "Already Exists",
                    new IllegalArgumentException());
        }

        objectRepository.save(Object.builder()
                .name(dto.getName())
                .ea(dto.getEa())
                .category(dto.getCategory())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build());

    }

    public List<Dto.ObjectRes> getAllObject() {
        List<Object> objectList = objectRepository.findAll();
        return objectList.stream().map(object ->objectMapper.objectToDto(object)).collect(Collectors.toList());
    }

    public List<Dto.ObjectRes> getByCategory(String category) {
        return objectMapper.objectListToDto(objectRepository.findAllByCategoryOrderByName(category));
    }

    public void changeObjectEa(Dto.NumberInput dto) {
        objectRepository.updateEa(dto.getName(), dto.getNumber());
    }

    public void deleteObject(Dto.Name dto) {
        objectRepository.deleteByName(dto.getName());
    }
}
