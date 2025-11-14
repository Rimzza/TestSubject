package by.nikita.TestProject.database.jdbcQuery;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEducationQuery {

  private final JdbcTemplate jdbc;


  public void deleteByUserIdAndName(UUID id, String name){
    jdbc.update("DELETE FROM user_education  WHERE user_id = ? AND institute = ?", id, name);

  }

}
