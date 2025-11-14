package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Модель запроса на добавление нового учебного заведения пользователя")
public record EducationAddRequest(

    @Schema(description = "Новое название учебного заведения",example = "БГСХА")
    String institute,

    @Schema(description = "Дата начала обучения", example = "2016-08-10")
    LocalDate dateStart,

    @Schema(description = "Дата окончания обучения", example = "2020-08-10")
    LocalDate dateEnd
) {

}
