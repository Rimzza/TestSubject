package by.nikita.TestProject.controller;

import by.nikita.TestProject.dto.request.FIOUpdateRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import by.nikita.TestProject.dto.response.DeleteUserResponse;
import by.nikita.TestProject.dto.response.FIOUpdateResponse;
import by.nikita.TestProject.dto.response.RegistrationResponse;
import by.nikita.TestProject.dto.response.UserInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

@Tag(name = "User API",
description = "API для управления данными пользователя")
public interface UserController {

  @Operation(
      summary = "Регистрация нового пользователя.",
      description = "Возвращает UUID аккаунта, успешно зарегистрировано."
  )
  @ApiResponse(responseCode = "200", description = "Возвращение UUID")
  ResponseEntity<RegistrationResponse> registerNewUser(RegistrationRequest request);

  @Operation(
      summary = "Получение основной информации человека по UUID",
      description = "Возвращает информацию по человеку."
  )
  @ApiResponse(responseCode = "200", description = "Возвращение записи об человеке")
  ResponseEntity<UserInfoResponse> getUser(UUID id);

  @Operation(
      summary = "Обновление ФИО человека по UUID",
      description = "Обновляет ФИО(имя, фамилия) человека"
  )
  @ApiResponse(responseCode = "200", description = "Смена ФИО прошла успешна.")
  ResponseEntity<FIOUpdateResponse> updateFio(FIOUpdateRequest request, UUID id);

  @Operation(
      summary = "Удаление информации о человека по UUID",
      description = "Удаление записи об человеке(удалятся практически все связанные записи)"
  )
  @ApiResponse(responseCode = "200", description = "Пользователь с id:%s успешно удален.")
  ResponseEntity<DeleteUserResponse> deleteUser(UUID id);

}
