package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель запроса на удаление учебного заведения пользователя")
public record EducationDeleteRequest(

    @Schema(description = "Название учебного заведения, которое надо удалить", example = "БГСХА")
    String institute
) {

}
