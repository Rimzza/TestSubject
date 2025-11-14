package by.nikita.TestProject.service;

import by.nikita.TestProject.dto.request.CredentialsUpdateRequest;
import by.nikita.TestProject.dto.response.CredentialsUpdateResponse;
import java.util.UUID;

public interface UserCredentialsService {

  CredentialsUpdateResponse updateCredentials(CredentialsUpdateRequest request,UUID id);
}
