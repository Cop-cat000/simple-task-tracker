package ruslan.simple_task_tracker.persistence.entities.authorization;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class AuthorizationUser {

    @Id
    private String id;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Roles getRole() { return role; }
    public void setRole(Roles role) { this.role = role; }
}
