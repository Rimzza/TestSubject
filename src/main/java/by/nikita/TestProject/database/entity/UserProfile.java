package by.nikita.TestProject.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "birthday")
  private LocalDate birthday;

  @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
  private UserCredentials credentials;

  @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
  private List<UserEducation> userEducations;

  @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
  private RegistrationAddress registrationAddress;



}
