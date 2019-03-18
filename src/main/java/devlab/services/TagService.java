package devlab.services;

import devlab.mappers.TagMapper;
import devlab.models.dtos.TagDto;
import devlab.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;
    private TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public List<TagDto> getTags() {
        return tagRepository
                .findAll()
                .stream()
                .map(tagMapper::map)
                .collect(Collectors.toList());
    }
}
