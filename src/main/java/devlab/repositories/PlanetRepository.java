package devlab.repositories;


import devlab.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
 *
 * @Repository - wyjątki związane z bazą danych są zamieniane na „springowe”  DataAccessExceptions
 * Każda adnotację da się zastąpić @Component
 *
 *
 * */

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {


//    @Query(value = "select * from planets where planet_name = ?1", nativeQuery = true) //SQL
    @Query("select p from Planet p where p.planetName = ?1") //JPQL
    Optional<Planet> findPlanetByPlanetName(String planetName);


    @Transactional
    @Modifying
    @Query("select p from Planet p where p.planetName = ?1")
    void deletePlanetByPlanetName(String planetName);


    @Query("select p from Planet p where p.distanceFromSun <= ?1")
    List<Planet> findPlanetsByDistanceFromSun(Long distance);

}
