package by.nikita.TestProject.mapper;

import by.nikita.TestProject.database.entity.UserEducation;
import java.time.LocalDate;

public class DefaultUtills {

  public static UserEducation createDefaultEducation(){
    UserEducation education = new UserEducation();
    education.setInstitute("default");
    education.setDateStart(LocalDate.now());
    education.setDateEnd(LocalDate.now());
    return education;
  }

}
