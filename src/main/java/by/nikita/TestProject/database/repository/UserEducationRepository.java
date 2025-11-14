package by.nikita.TestProject.database.repository;

import by.nikita.TestProject.database.entity.UserEducation;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserEducationRepository extends CrudRepository<UserEducation, Integer> {

  @Query("""
      SELECT e FROM UserEducation e
      WHERE e.userProfile.id = :userId AND e.institute = :name
      """
  )
  Optional<UserEducation> findByUserIdAndName(@Param("userId") UUID userId,
      @Param("name") String name);

 /* @Modifying
  @Query("""
      DELETE FROM UserEducation e
      WHERE e.userProfile.id = : userId AND e.institute = :name
      """)*/
  @NativeQuery(value = "DELETE FROM user_education e WHERE user_id = ?1 AND institute = ?2")
  void deleteByUserIdAndName( UUID userId, String name);

}
