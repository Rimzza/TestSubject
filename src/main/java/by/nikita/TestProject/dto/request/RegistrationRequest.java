package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Модель запроса на регистрацию нового пользователя")
public record RegistrationRequest(

    @Schema(description = "Имя пользователя",example = "Олег")
    String firstName,

    @Schema(description = "Фамилия пользователя",example = "Глаз")
    String middleName,

    @Schema(description = "День рождения пользователя", example = "2001-08-10")
    LocalDate birthday,

    @Schema(description = "Логин пользователя", example = "rimza")
    String login,

    @Schema(description = "Пароль пользователя", example = "password1234")
    String password,

    @Schema(description = "Учебное заведение", example = "БНТУ")
    String institute,

    @Schema(description = "Дата начала обучения", example = "2018-08-10")
    LocalDate dateStart,

    @Schema(description = "Дата окончания обучения", example = "2022-08-10")
    LocalDate dateEnd,

    @Schema(description = "Регион проживания", example = "Минская обл.")
    String region,

    @Schema(description = "Город проживания", example = "Борисов")
    String city,

    @Schema(description = "Улица проживания", example = "Становская 7")
    String street
) {

}
