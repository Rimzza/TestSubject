package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель запроса на изменение логина/пароля пользователя")
public record CredentialsUpdateRequest(

    @Schema(description = "Новый логин",example = "missrain")
    String newLogin,

    @Schema(description = "Новый пароль",example = "61689")
    String newPassword
) {
}
