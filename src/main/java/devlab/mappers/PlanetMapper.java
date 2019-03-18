package devlab.mappers;

import devlab.commons.Mapper;
import devlab.models.Planet;
import devlab.models.Tag;
import devlab.models.dtos.PlanetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {

    @Override
    public PlanetDto map(Planet f) {


        List<String> tags = f.getTags()
                .stream()
                .map(TagsToStringsList.INSTANCE)
                .collect(Collectors.toList());


        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetType(f.getPlanetType())
                .planetInfo(f.getPlanetInfo())
                .planetImage(f.getPlanetImage())
                .tags(tags)
                .build();
    }

    @Override
    public Planet reverseMap(PlanetDto t) {
        return Planet
                .builder()
                .planetName(t.getPlanetName())
                .distanceFromSun(t.getDistanceFromSun())
                .oneWayLightTimeToTheSun(t.getOneWayLightTimeToTheSun())
                .lengthOfYear(t.getLengthOfYear())
                .planetType(t.getPlanetType())
                .planetInfo(t.getPlanetInfo())
                .planetImage(t.getPlanetImage())
                .build();
    }


    private enum TagsToStringsList implements Function<Tag, String> {
        INSTANCE;

        @Override
        public String apply(Tag tag) {
            return tag.getTitle();
        }
    }
}
