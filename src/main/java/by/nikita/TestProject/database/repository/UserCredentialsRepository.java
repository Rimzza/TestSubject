package by.nikita.TestProject.database.repository;

import by.nikita.TestProject.database.entity.UserCredentials;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, UUID> {

}
