package by.nikita.TestProject.controller.Impl;

import by.nikita.TestProject.controller.RegistrationAddressController;
import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import by.nikita.TestProject.service.RegistrationAddressService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/user")
@RequiredArgsConstructor
public class RegistrationAddressControllerImpl implements RegistrationAddressController {

  private final RegistrationAddressService regService;

  @Override
  @PatchMapping("/{id}/registrationAddress")
  public ResponseEntity<DefaultResponse> updateRegistrationAddress(
      @RequestBody RegistrationAddressChangeRequest request,@PathVariable("id") UUID id) {
    DefaultResponse response = regService.updateRegistrationAddress(request, id);
    return ResponseEntity.ok(response);
  }

  @Override
  @PostMapping("/{id}/registrationAddress")
  public ResponseEntity<DefaultResponse> addNewRegistrationAddress(
      @RequestBody RegistrationAddressChangeRequest request,@PathVariable("id") UUID id) {

    DefaultResponse response = regService.addRegistrationAddress(request, id);

    return ResponseEntity.ok(response);
  }
}
