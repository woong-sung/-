package jojo.shop.object.main;

import jojo.shop.object.Dto;
import jojo.shop.object.Object.ObjectService;
import jojo.shop.object.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ObjectService objectService;
    private final CategoryService categoryService;

    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public String getMainPage(Model model) {
        List<String> categories = categoryService.getCategoriesName();
        model.addAttribute("category", categories);
        List<Dto.ObjectRes> allList = objectService.getAllObject();
        model.addAttribute("objects", allList);
        return "/mainPage";
    }

    @GetMapping("/objects")
    @ResponseStatus(HttpStatus.OK)
    public String getRegisterPage(Model model) {
        List<String> categories = categoryService.getCategoriesName();
        model.addAttribute("category", categories);
        List<Dto.ObjectRes> allList = objectService.getAllObject();
        model.addAttribute("objects", allList);
        return "/registerPage";
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public String getCategoryPage(Model model) {
        List<String> categories = categoryService.getCategoriesName();
        model.addAttribute("category", categories);
        return "/categoryPage";
    }
}
