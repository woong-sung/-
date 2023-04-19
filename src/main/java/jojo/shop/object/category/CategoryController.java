package jojo.shop.object.category;

import jojo.shop.object.Dto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postCategory(@RequestBody Dto.Name dto) {
        categoryService.saveNewCategory(dto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Dto.CategoryRes getCategories(){
        return Dto.CategoryRes.builder().list(categoryService.getCategories()).build();
    }
}
