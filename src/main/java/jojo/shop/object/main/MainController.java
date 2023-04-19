package jojo.shop.object.main;

import jojo.shop.object.Dto;
import jojo.shop.object.Object.ObjectService;
import jojo.shop.object.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ObjectService objectService;
    private final CategoryService categoryService;
    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Dto.MainRes getMainPage(){
        List<String> categories =  categoryService.getCategoriesName();
        List<Dto.OrderByCategoryRes> list = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Dto.OrderByCategoryRes res = Dto.OrderByCategoryRes
                    .builder()
                    .category(categories.get(i))
                    .objectResList(objectService.getByCategory(categories.get(i)))
                    .build();
            list.add(res);
        }
        return Dto.MainRes.builder()
                .data(list)
                .build();
    }
}
