package devlab.mappers;

import devlab.commons.Mapper;
import devlab.models.Planet;
import devlab.models.Tag;
import devlab.models.dtos.TagDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TagMapper implements Mapper<Tag, TagDto> {


    @Override
    public TagDto map(Tag f) {

        Set<String> names = f
                .getPlanets()
                .stream()
                .map(getName.INSTANCE)
                .collect(Collectors.toSet());

        return TagDto.builder()
                .title(f.getTitle())
                .planetName(names)
                .build();
    }

    @Override
    public Tag reverseMap(TagDto to) {
        return null;
    }


    private enum getName implements Function<Planet, String> {
        INSTANCE;

        @Override
        public String apply(Planet planet) {
            return planet.getPlanetName();
        }
    }
}
