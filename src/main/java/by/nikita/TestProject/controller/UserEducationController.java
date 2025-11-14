package by.nikita.TestProject.controller;

import by.nikita.TestProject.dto.request.EducationAddRequest;
import by.nikita.TestProject.dto.request.EducationChangeRequest;
import by.nikita.TestProject.dto.request.EducationDeleteRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

@Tag(name = "UserEducation API",
description = "API для управления данными об образование человека.")
public interface UserEducationController {

  @Operation(
      summary = "Обновить существующую запись об образование по UUID человка.",
      description = "Возвращает ответ с успешным изменением."
  )
  @ApiResponse(responseCode = "200", description = "Учебное учреждение успешно изменено с %s на %s.")
  ResponseEntity<DefaultResponse> updateEducation(EducationChangeRequest request, UUID id);

  @Operation(
      summary = "Добавить новую запись об образование по UUID человка.",
      description = "Возвращает ответ с успешным изменением."
  )
  @ApiResponse(responseCode = "200", description = "Учебное учреждение успешно добавлено.")
  ResponseEntity<DefaultResponse> addEducation(EducationAddRequest request, UUID id);

  @Operation(
      summary = "Удалить запись об образование по UUID человка.",
      description = "Возвращает ответ с успешным удаление."
  )
  @ApiResponse(responseCode = "200", description = "Учебеное учреждение успешно удалено.")
  ResponseEntity<DefaultResponse> deleteEducation(EducationDeleteRequest request, UUID id);



}
