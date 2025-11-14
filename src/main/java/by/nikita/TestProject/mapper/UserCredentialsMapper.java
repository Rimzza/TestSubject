package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.UserCredentials;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserCredentialsMapper {

  public UserCredentials toUseUserCredentials(RegistrationRequest request);

}
