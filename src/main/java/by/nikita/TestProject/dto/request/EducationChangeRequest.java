package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Модель запроса на изменение существующего учебного заведения пользователя")
public record EducationChangeRequest(

    @Schema(description = "тарое название учебного заведения",example = "БГСХА")
    String oldInstitute,


    @Schema(description = "Новое название учебного заведения",example = "БГУТ")
    String newInstitute,

    @Schema(description = "Дата начала обучения", example = "2017-08-10")
    LocalDate dateStart,

    @Schema(description = "Дата окончания обучения", example = "2021-08-10")
    LocalDate dateEnd
) {

}
