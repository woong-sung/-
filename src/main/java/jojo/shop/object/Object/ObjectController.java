package jojo.shop.object.Object;

import jojo.shop.object.Dto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/object")
@AllArgsConstructor
public class ObjectController {
    private final ObjectService objectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postObject(@RequestBody Dto.ObjectInput dto) {
        objectService.saveNewObject(dto);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateObjectEa(@RequestBody Dto.NumberInput dto) {
        objectService.changeObjectEa(dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObject(@RequestBody Dto.Name dto){
        objectService.deleteObject(dto);
    }
}
