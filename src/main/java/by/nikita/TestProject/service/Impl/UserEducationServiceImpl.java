package by.nikita.TestProject.service.Impl;

import by.nikita.TestProject.database.entity.UserEducation;
import by.nikita.TestProject.database.repository.UserEducationRepository;
import by.nikita.TestProject.database.jdbcQuery.UserEducationQuery;
import by.nikita.TestProject.dto.request.EducationAddRequest;
import by.nikita.TestProject.dto.request.EducationChangeRequest;
import by.nikita.TestProject.dto.request.EducationDeleteRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import by.nikita.TestProject.mapper.UserEducationMapper;
import by.nikita.TestProject.service.UserEducationService;
import by.nikita.TestProject.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEducationServiceImpl implements UserEducationService {

  private final UserEducationRepository educationRepository;

  private final UserService userService;

  private final UserEducationMapper educationMapper;

  private final UserEducationQuery educationQueryquery;


  @Override
  public DefaultResponse updateEducation(EducationChangeRequest request, UUID id) {
    UserEducation education = educationRepository.findByUserIdAndName(id,
        request.oldInstitute()).get();

    education.setInstitute(request.newInstitute());
    education.setDateStart(request.dateStart());
    education.setDateEnd(request.dateEnd());

    educationRepository.save(education);

    return new DefaultResponse(
        String.format("Учебное учреждение успешно изменено с %s на %s.", request.oldInstitute(),
            request.newInstitute()));
  }

  @Override
  public DefaultResponse addEducation(EducationAddRequest request, UUID id) {

    UserEducation education = educationMapper.toUserEducation(request);
    education.setUserProfile(userService.getUserProfile(id));

    educationRepository.save(education);
    return new DefaultResponse("Учебеное учреждение успешно добавлено.");
  }

  @Override
  public DefaultResponse deleteEducation(EducationDeleteRequest request, UUID id) {
    educationQueryquery.deleteByUserIdAndName(id, request.institute());
    return new DefaultResponse("Учебеное учреждение успешно удалено.");
  }
}
