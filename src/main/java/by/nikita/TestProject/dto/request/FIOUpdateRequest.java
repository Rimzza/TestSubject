package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Модель запроса на изменение ФИО(имя, фамилия) пользователя")
public record FIOUpdateRequest(

    @Schema(description = "Новое имя пользователя",example = "Никита")
    String newFirstName,

    @Schema(description = "Новая фамилия пользователя",example = "Егоров")
    String newMiddleName) {
}
