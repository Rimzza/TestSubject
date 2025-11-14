package by.nikita.TestProject.database.repository;

import by.nikita.TestProject.database.entity.City;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

  boolean existsByName(String name);

  City findByName(String name);

  @NativeQuery(value = "SELECT id FROM city_info  WHERE name = ?1")
  Integer getIdByName(String name);
  
}
