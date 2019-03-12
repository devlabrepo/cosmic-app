package devlab.mappers;

import devlab.commons.Mapper;
import devlab.models.Planet;
import devlab.models.dtos.PlanetDto;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {

    @Override
    public PlanetDto map(Planet f) {
        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetType(f.getPlanetType())
                .planetInfo(f.getPlanetInfo())
                .planetImage(f.getPlanetImage())
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
}
