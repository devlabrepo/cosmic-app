package devlab.controllers;



import devlab.commons.annotations.ApiVersionPrefix;
import devlab.models.dtos.TagDto;
import devlab.services.TagService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@ApiVersionPrefix
public class TagController {

    private TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;

    }

    @GetMapping("/dto/tags")
    public List<TagDto> getTags() {
        return tagService.getTags();
    }
}
