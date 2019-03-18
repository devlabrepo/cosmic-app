package devlab.controllers;


import devlab.commons.annotations.ApiVersionPrefix;
import devlab.models.Planet;
import devlab.models.dtos.PlanetDto;
import devlab.services.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiVersionPrefix // wlasna adnotacja dodajaca "/api/v1"
@CrossOrigin
@RestController
//@RequestMapping(path = "${api.path}") //- patrz application.properties -> api.path
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        return planetService.getPlanets();
    }

    /*
     *
     * DTO - Data Transfer Object
     *
     */

//    @GetMapping("/dto/planets/")
//    public List<PlanetDto> getPlanetsDto() {
//        return planetService.getPlanetsDto();
//    }

    @PostMapping("/dto/planets")
    public Planet addPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.addPlanet(planetDto);
    }

    @PutMapping("/dto/planets")
    public void updatePlanet(@RequestBody PlanetDto planetDto) {
        planetService.updatePlanet(planetDto);
    }

    @DeleteMapping("/dto/planets/{planetName}")
    public void deletePlanet(@PathVariable String planetName) {
        planetService.deletePlanet(planetName);
    }

    @GetMapping("/dto/planets")
    public List<PlanetDto> getPlanetsDto(@RequestParam(value = "distance", required = false) Long distance) {
        if(distance != null && distance > 0) {
            return planetService.getPlanetsByDistanceFromSun(distance);
        }
        return planetService.getPlanetsDto();
    }

}
