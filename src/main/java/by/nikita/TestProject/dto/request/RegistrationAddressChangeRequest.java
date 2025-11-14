package by.nikita.TestProject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель запроса на изменение/добавление адреса регистрации")
public record RegistrationAddressChangeRequest(

    @Schema(description = "Название нового региона",example = "Минская обл.")
    String newRegion,

    @Schema(description = "Название новой улицы", example = "Становская 7")
    String newStreet,

    @Schema(description = "Название новой города", example = "Борисов")
    String newCity
) {

}
