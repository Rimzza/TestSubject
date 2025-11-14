package by.nikita.TestProject.controller.Impl;

import by.nikita.TestProject.controller.UserEducationController;
import by.nikita.TestProject.dto.request.EducationAddRequest;
import by.nikita.TestProject.dto.request.EducationChangeRequest;
import by.nikita.TestProject.dto.request.EducationDeleteRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import by.nikita.TestProject.service.UserEducationService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEducationControllerImpl implements UserEducationController {

  private final UserEducationService educationService;

  @Override
  @PatchMapping("/{id}/education")
  public ResponseEntity<DefaultResponse> updateEducation(
      @RequestBody EducationChangeRequest request,
      @PathVariable("id") UUID id) {
    DefaultResponse response = educationService.updateEducation(request, id);

    return ResponseEntity.ok(response);
  }

  @Override
  @PostMapping("{id}/education")
  public ResponseEntity<DefaultResponse> addEducation(@RequestBody EducationAddRequest request,
      @PathVariable("id") UUID id) {
    DefaultResponse response = educationService.addEducation(request, id);

    return ResponseEntity.ok(response);
  }

  @Override
  @DeleteMapping("{id}/education")
  public ResponseEntity<DefaultResponse> deleteEducation(
      @RequestBody EducationDeleteRequest request, @PathVariable UUID id) {
    DefaultResponse response = educationService.deleteEducation(request, id);

    return ResponseEntity.ok(response);
  }

}
