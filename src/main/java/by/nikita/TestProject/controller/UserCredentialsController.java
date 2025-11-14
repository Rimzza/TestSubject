package by.nikita.TestProject.controller;

import by.nikita.TestProject.dto.request.CredentialsUpdateRequest;
import by.nikita.TestProject.dto.response.CredentialsUpdateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

@Tag(name = "UserCredentials API",
description = "API для управления логином и паролем пользователя")
public interface UserCredentialsController {

  @Operation(
      summary = "Изменение логина и пароля по UUID пользователя",
      description = "Изменение логина и пароля по UUID пользователя."
  )
  @ApiResponse(responseCode = "200", description = "Возвращение  новый логин и пароль")
  ResponseEntity<CredentialsUpdateResponse> changeCredentials(
      CredentialsUpdateRequest request, UUID id);

}
