package by.nikita.TestProject.service.Impl;

import by.nikita.TestProject.database.entity.City;
import by.nikita.TestProject.database.entity.RegistrationAddress;
import by.nikita.TestProject.database.repository.CityRepository;
import by.nikita.TestProject.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;

  @Override
  public City getCity(String name) {
    boolean exits = cityRepository.existsByName(name);
    City city = null;
    if (exits) {
      city = cityRepository.findByName(name);
    }
    return city;
  }

  @Override
  public City create(RegistrationAddress address, String name) {
    City city = new City();
    city.setPopulation(10000);
    city.setName(name);
    city.setInfo("default");
    city.setAddresses(List.of(address));
    return city;
  }


}
