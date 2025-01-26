package ruslan.simple_task_tracker_authorization_server.persistence.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "users")
public class User {

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
