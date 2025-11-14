package by.nikita.TestProject.database.repository;

import by.nikita.TestProject.database.entity.UserProfile;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, UUID> {

}
