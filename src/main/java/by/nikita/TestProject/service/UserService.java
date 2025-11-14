package by.nikita.TestProject.service;

import by.nikita.TestProject.database.entity.UserProfile;
import by.nikita.TestProject.dto.request.FIOUpdateRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import by.nikita.TestProject.dto.response.DeleteUserResponse;
import by.nikita.TestProject.dto.response.FIOUpdateResponse;
import by.nikita.TestProject.dto.response.RegistrationResponse;
import by.nikita.TestProject.dto.response.UserInfoResponse;
import java.util.UUID;

public interface UserService {

  UserInfoResponse getUserInfo(UUID id);

  UserProfile getUserProfile(UUID id);

  RegistrationResponse registerNewUser(RegistrationRequest request);

  FIOUpdateResponse updateFio(FIOUpdateRequest request, UUID id);

  DeleteUserResponse deleteUser(UUID id);



}
