package by.nikita.TestProject.dto.response;

import java.time.LocalDate;

public record UserInfoResponse(
    String fullName,
    LocalDate birthday,
    String login,
    String registration
) {

}
