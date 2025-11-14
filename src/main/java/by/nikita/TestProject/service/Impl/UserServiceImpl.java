package by.nikita.TestProject.service.Impl;

import by.nikita.TestProject.database.entity.UserEducation;
import by.nikita.TestProject.database.entity.UserProfile;
import by.nikita.TestProject.database.repository.UserProfileRepository;
import by.nikita.TestProject.dto.request.FIOUpdateRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import by.nikita.TestProject.dto.response.DeleteUserResponse;
import by.nikita.TestProject.dto.response.FIOUpdateResponse;
import by.nikita.TestProject.dto.response.RegistrationResponse;
import by.nikita.TestProject.dto.response.UserInfoResponse;
import by.nikita.TestProject.mapper.DefaultUtills;
import by.nikita.TestProject.mapper.RegistrationMapper;
import by.nikita.TestProject.mapper.UserInfoMapper;
import by.nikita.TestProject.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserProfileRepository userRepository;

  private final UserInfoMapper userMapper;

  private final RegistrationMapper regMapper;

  @Override
  public UserInfoResponse getUserInfo(UUID id) {
    UserProfile userProfile = userRepository.findById(id).get();
    return userMapper.toUserInfoResponse(userProfile);
  }

  @Override
  public UserProfile getUserProfile(UUID id) {
    UserProfile userProfile = userRepository.findById(id).get();
    return userProfile;
  }

  @Override
  public RegistrationResponse registerNewUser(RegistrationRequest request) {
    UserProfile userProfile = userMapper.toUserProfile(request);

    userProfile.getCredentials().setUserProfile(userProfile);
    userProfile.getRegistrationAddress().setUserProfile(userProfile);
    userProfile.getRegistrationAddress().getCity().setAddresses(
        List.of(userProfile.getRegistrationAddress()));
    UserEducation education = DefaultUtills.createDefaultEducation();
    education.setUserProfile(userProfile);
    userProfile.setUserEducations(List.of(education));

    userRepository.save(userProfile);
    return userMapper.toRegistrationResponse(userProfile);
  }

  @Override
  public FIOUpdateResponse updateFio(FIOUpdateRequest request, UUID id) {
    UserProfile userProfile = userRepository.findById(id).get();

    userProfile.setFirstName(request.newFirstName());
    userProfile.setMiddleName(request.newMiddleName());

    userRepository.save(userProfile);
    return new FIOUpdateResponse(id, "Смена ФИО прошла успешна");
  }

  @Override
  public DeleteUserResponse deleteUser(UUID id) {
    userRepository.deleteById(id);
    return new DeleteUserResponse(id, String.format("Пользователь с id:%s успешно удален", id));
  }

}
