package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.RegistrationAddress;
import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
uses = {CityMapper.class})
public interface RegistrationMapper {

  @Mapping(target = "city", source = "request")
  public RegistrationAddress toRegistrationAddress(RegistrationRequest request);

  @Mapping(target = "region", source = "newRegion")
  @Mapping(target = "street", source = "newStreet")
  public RegistrationAddress toRegistrationAddress(RegistrationAddressChangeRequest request);

}
