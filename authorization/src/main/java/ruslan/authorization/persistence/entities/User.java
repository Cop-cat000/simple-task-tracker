package ruslan.authorization.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;
}
