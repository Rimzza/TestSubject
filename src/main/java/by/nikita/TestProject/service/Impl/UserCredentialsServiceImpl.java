package by.nikita.TestProject.service.Impl;

import by.nikita.TestProject.database.entity.UserCredentials;
import by.nikita.TestProject.database.repository.UserCredentialsRepository;
import by.nikita.TestProject.dto.request.CredentialsUpdateRequest;
import by.nikita.TestProject.dto.response.CredentialsUpdateResponse;
import by.nikita.TestProject.service.UserCredentialsService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialsServiceImpl implements UserCredentialsService {

  private final UserCredentialsRepository credRepository;

  @Override
  public CredentialsUpdateResponse updateCredentials(CredentialsUpdateRequest request, UUID id) {
    UserCredentials credentials = credRepository.findById(id).get();
    credentials.setLogin(request.newLogin());
    credentials.setPassword(request.newPassword());

    credRepository.save(credentials);

    return new CredentialsUpdateResponse(request.newLogin(), "Изменение логина и пароля прошла успешна");
  }
}
