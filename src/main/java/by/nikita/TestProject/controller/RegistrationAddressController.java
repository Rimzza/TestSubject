package by.nikita.TestProject.controller;

import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

@Tag(name = "RegistrationAddress API",
description = "API для управления данными об регистрации пользователя.")
public interface RegistrationAddressController {

  @Operation(
      summary = "Обновление существующего адреса регистрации пользователя."
  )
  @ApiResponse(responseCode = "200", description = "Обновление регистрации успешно.")
  ResponseEntity<DefaultResponse> updateRegistrationAddress(
      RegistrationAddressChangeRequest request, UUID id);

  @Operation(
      summary = "Добавление нового адреса регистрации пользователя."
  )
  @ApiResponse(responseCode = "200", description = "Обновление регистрации успешно.")
  ResponseEntity<DefaultResponse> addNewRegistrationAddress(
      RegistrationAddressChangeRequest request, UUID id);


}
