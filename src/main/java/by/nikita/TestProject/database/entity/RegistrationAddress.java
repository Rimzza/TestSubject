package by.nikita.TestProject.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "registration_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationAddress {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String region;

  private String street;

  @ManyToOne
  @JoinColumn(name = "city")
  @Cascade(value = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
  private City city;

  @OneToOne
  @JoinColumn(name = "user_id")
  @MapsId
  private UserProfile userProfile;

}
