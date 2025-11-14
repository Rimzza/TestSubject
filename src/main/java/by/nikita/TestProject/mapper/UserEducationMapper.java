package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.UserEducation;
import by.nikita.TestProject.dto.request.EducationAddRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEducationMapper {


  public UserEducation toUserEducation(EducationAddRequest request);


}
