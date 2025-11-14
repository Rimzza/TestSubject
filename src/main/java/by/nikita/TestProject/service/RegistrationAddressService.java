package by.nikita.TestProject.service;

import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import java.util.UUID;

public interface RegistrationAddressService {

  DefaultResponse updateRegistrationAddress(RegistrationAddressChangeRequest request, UUID id);

  DefaultResponse addRegistrationAddress(RegistrationAddressChangeRequest request, UUID id);

}
