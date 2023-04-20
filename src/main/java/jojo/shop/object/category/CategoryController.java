package jojo.shop.object.category;

import jojo.shop.object.Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/category")
    public String postCategory(@ModelAttribute Dto.Name dto) {
        categoryService.saveNewCategory(dto.getName());
        return "redirect:/categories";
    }

    @GetMapping("/category/all")
    public Dto.CategoryRes getCategories(){
        return Dto.CategoryRes.builder().list(categoryService.getCategories()).build();
    }

    @DeleteMapping("/category")
    public String deleteCategory(@RequestParam String name) {
        categoryService.deleteByName(name);
        return "redirect:/categories";
    }
}
