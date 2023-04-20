package jojo.shop.object.category;

import jojo.shop.object.Dto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void saveNewCategory(String name){
        if (categoryRepository.findByName(name).isPresent()) {
            throw new ResponseStatusException(409,
                    "Already Exists",
                    new IllegalArgumentException());
        }
        categoryRepository.save(Category.builder().name(name).build());
    }

    public List<Dto.Name> getCategories() {
        List<Category> list = categoryRepository.findAll();
        List<Dto.Name> categories = new ArrayList<>();
        list.stream().map(category -> categories.add(Dto.Name.builder().name(category.getName()).build()));
        return categories;
    }

    public List<String> getCategoriesName(){
        List<Category> list = categoryRepository.findAll();
        List<String> categoryNames = list.stream().map(category -> category.getName()).collect(Collectors.toList());
        return categoryNames;
    }

    public void deleteByName(String name) {
        categoryRepository.deleteByName(name);
    }
}
