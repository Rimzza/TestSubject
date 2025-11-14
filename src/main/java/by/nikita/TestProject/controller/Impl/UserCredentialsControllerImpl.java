package by.nikita.TestProject.controller.Impl;

import by.nikita.TestProject.controller.UserCredentialsController;
import by.nikita.TestProject.dto.request.CredentialsUpdateRequest;
import by.nikita.TestProject.dto.response.CredentialsUpdateResponse;
import by.nikita.TestProject.service.UserCredentialsService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCredentialsControllerImpl implements UserCredentialsController {

  private final UserCredentialsService credService;

  @Override
  @PatchMapping("/{id}/changePassword")
  public ResponseEntity<CredentialsUpdateResponse> changeCredentials(
    @RequestBody CredentialsUpdateRequest request,@PathVariable("id") UUID id) {

    CredentialsUpdateResponse response = credService.updateCredentials(request, id);

    return ResponseEntity.ok(response);
  }
}
