package by.nikita.TestProject.service;

import by.nikita.TestProject.dto.request.EducationAddRequest;
import by.nikita.TestProject.dto.request.EducationChangeRequest;
import by.nikita.TestProject.dto.request.EducationDeleteRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import java.util.UUID;

public interface UserEducationService {

  DefaultResponse updateEducation(EducationChangeRequest request,
      UUID id);

  DefaultResponse addEducation(EducationAddRequest request, UUID id);

  DefaultResponse deleteEducation(EducationDeleteRequest request, UUID id);

}
