package devlab.services;

import devlab.mappers.PlanetMapper;
import devlab.models.Planet;
import devlab.models.dtos.PlanetDto;
import devlab.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {


    private PlanetRepository planetRepository;
    private PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }

    /*
     *
     * DAO - Data Access Object
     *
     */

    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    /*
     *
     * DTO - Data Transfer Object
     *
     */

    public List<PlanetDto> getPlanetsDto() {
        return planetRepository
                .findAll()
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

    public Planet addPlanet(PlanetDto planetDto) {
        return planetRepository.save(planetMapper.reverseMap(planetDto));
    }

    public void updatePlanet(PlanetDto planetDto) {

        planetRepository
                .findPlanetByPlanetName(planetDto.getPlanetName())
                .ifPresent(p -> {

                    p.setDistanceFromSun(planetDto.getDistanceFromSun());
                    p.setOneWayLightTimeToTheSun(planetDto.getOneWayLightTimeToTheSun());
                    p.setLengthOfYear(planetDto.getLengthOfYear());
                    p.setPlanetType(planetDto.getPlanetType());
                    p.setPlanetInfo(planetDto.getPlanetInfo());
                    p.setPlanetImage(planetDto.getPlanetImage());

                    planetRepository.save(p);
                });
    }

    public void deletePlanet(String planetName) {
        planetRepository.deletePlanetByPlanetName(planetName);
    }

    public List<PlanetDto> getPlanetsByDistanceFromSun(Long distance) {

        return planetRepository.findPlanetsByDistanceFromSun(distance)
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

}
