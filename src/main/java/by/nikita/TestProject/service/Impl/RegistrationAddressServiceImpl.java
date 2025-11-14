package by.nikita.TestProject.service.Impl;

import by.nikita.TestProject.database.entity.City;
import by.nikita.TestProject.database.entity.RegistrationAddress;
import by.nikita.TestProject.database.repository.RegistrationAddressRepository;
import by.nikita.TestProject.dto.request.RegistrationAddressChangeRequest;
import by.nikita.TestProject.dto.response.DefaultResponse;
import by.nikita.TestProject.mapper.CityMapper;
import by.nikita.TestProject.service.CityService;
import by.nikita.TestProject.service.RegistrationAddressService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationAddressServiceImpl implements RegistrationAddressService {


  private final RegistrationAddressRepository addressRepository;

  private final CityService cityService;

  private final CityMapper cityMapper;

  @Override
  public DefaultResponse updateRegistrationAddress(RegistrationAddressChangeRequest request,
      UUID id) {
    RegistrationAddress address = addressRepository.findByUserId(id).get();

    address.setRegion(request.newRegion());
    address.setStreet(request.newStreet());

    if (!isSameCity(request, address)) {
      City city = getCity(request.newCity());
      if (city == null) {
        city = cityMapper.toCity(request);
        city.setAddresses(List.of(address));
      } else {
        city.getAddresses().add(address);
      }
      address.setCity(city);
      //City city = cityService.create(address, request.newCity());
      //address.setCity(city);
    }
    addressRepository.save(address);

    return new DefaultResponse("Обновление регистрации успешно.");
  }

  @Override
  public DefaultResponse addRegistrationAddress(RegistrationAddressChangeRequest request, UUID id) {
    RegistrationAddress address = addressRepository.findByUserId(id).get();
    if (!address.getCity().getName().equals(request.newCity())) {
      City city = cityMapper.toCity(request);
      city.setAddresses(List.of(address));
      address.setCity(city);
    }
    address.setRegion(request.newRegion());
    address.setStreet(request.newStreet());
    addressRepository.save(address);

    return new DefaultResponse("Новое место регистрации сохранено успешно.");
  }

  private boolean isSameCity(RegistrationAddressChangeRequest request,
      RegistrationAddress address) {
    return request.newCity().equals(address.getCity().getName());
  }

  private City getCity(String name) {
    return cityService.getCity(name);
  }

}
