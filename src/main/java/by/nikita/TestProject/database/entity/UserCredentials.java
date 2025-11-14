package by.nikita.TestProject.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String login;

  private String password;

  @OneToOne
  @JoinColumn(name = "user_id")
  @MapsId
  private UserProfile userProfile;

}
