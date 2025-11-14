package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.City;
import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CityMapper {

  @Mapping(target = "population", constant = "10000")
  @Mapping(target = "info", constant = "default")
  @Mapping(target = "name" , qualifiedByName = "getCityName", source = "city")
  public City toCity(RegistrationRequest request);

  @Mapping(target = "population", constant = "10000")
  @Mapping(target = "info", constant = "default")
  @Mapping(target = "name" , qualifiedByName = "getCityName", source = "newCity")
  public City toCity(RegistrationAddressChangeRequest request);

  @Named("getCityName")
  default String getCityName(String city){
    return  city;
  }

}
