package by.nikita.TestProject.controller.Impl;

import by.nikita.TestProject.controller.UserController;
import by.nikita.TestProject.dto.request.CredentialsUpdateRequest;
import by.nikita.TestProject.dto.request.FIOUpdateRequest;
import by.nikita.TestProject.dto.request.RegistrationRequest;
import by.nikita.TestProject.dto.response.CredentialsUpdateResponse;
import by.nikita.TestProject.dto.response.DeleteUserResponse;
import by.nikita.TestProject.dto.response.FIOUpdateResponse;
import by.nikita.TestProject.dto.response.RegistrationResponse;
import by.nikita.TestProject.dto.response.UserInfoResponse;
import by.nikita.TestProject.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControllerImpl implements UserController {


  private final UserService userService;

  @Override
  @PostMapping("/register")
  public ResponseEntity<RegistrationResponse> registerNewUser(@RequestBody RegistrationRequest request) {
    RegistrationResponse response = userService.registerNewUser(request);
    return ResponseEntity.ok(response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<UserInfoResponse> getUser(@PathVariable("id") UUID id) {
    UserInfoResponse response = userService.getUserInfo(id);
    return ResponseEntity.ok(response);
  }

  @Override
  @PatchMapping("/{id}")
  public ResponseEntity<FIOUpdateResponse> updateFio(@RequestBody FIOUpdateRequest request,@PathVariable("id") UUID id) {

    FIOUpdateResponse response = userService.updateFio(request, id);
    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("id") UUID id) {
    DeleteUserResponse response = userService.deleteUser(id);
    return ResponseEntity.ok(response);
  }

}
