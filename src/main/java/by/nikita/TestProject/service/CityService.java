package by.nikita.TestProject.service;

import by.nikita.TestProject.database.entity.City;
import by.nikita.TestProject.database.entity.RegistrationAddress;

public interface CityService {


  City getCity(String name);

  City create(RegistrationAddress address, String name);


}
