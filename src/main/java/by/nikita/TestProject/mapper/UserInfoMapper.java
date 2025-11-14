package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.UserProfile;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import by.nikita.TestProject.dto.response.RegistrationResponse;
import by.nikita.TestProject.dto.response.UserInfoResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
    uses = {
        UserCredentialsMapper.class,
        //UserEducationMapper.class,
        RegistrationMapper.class
    })
public interface UserInfoMapper {

  @Mapping(target = "fullName", qualifiedByName = "getFullName", source = "userProfile")
  @Mapping(target = "login", qualifiedByName = "getLogin", source = "userProfile")
  @Mapping(target = "registration", qualifiedByName = "getRegistration", source = "userProfile")
  UserInfoResponse toUserInfoResponse(UserProfile userProfile);

  List<UserInfoResponse> toUserInfoResponseList(List<UserProfile> userProfiles);

  @Mapping(target = "credentials", source = "request")
  @Mapping(target = "registrationAddress", source = "request")
  UserProfile toUserProfile(RegistrationRequest request);

  RegistrationResponse toRegistrationResponse(UserProfile userProfile);

  @Named("getFullName")
  default String getFullName (UserProfile userProfile){
    return String.format("%s %s", userProfile.getFirstName(), userProfile.getMiddleName());
  }

  @Named("getLogin")
  default String getLogin(UserProfile userProfile){
    return userProfile.getCredentials().getLogin();
  }

  @Named("getRegistration")
  default String getRegistration(UserProfile userProfile){
    return userProfile.getRegistrationAddress().getStreet();
  }

}
