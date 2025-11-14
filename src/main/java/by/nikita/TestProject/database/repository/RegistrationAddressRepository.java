package by.nikita.TestProject.database.repository;

import by.nikita.TestProject.database.entity.RegistrationAddress;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RegistrationAddressRepository extends CrudRepository<RegistrationAddress, UUID> {

  @Query("""
      SELECT r FROM RegistrationAddress r
      WHERE r.userProfile.id = :userId
      """)
  Optional<RegistrationAddress> findByUserId(@Param("userId") UUID userId);
}
