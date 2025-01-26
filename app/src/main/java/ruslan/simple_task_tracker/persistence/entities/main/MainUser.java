package ruslan.simple_task_tracker.persistence.entities.main;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class MainUser {

    @Id
    private String id;

    @OneToMany(mappedBy = "author") // fetch = FetchType.EAGER
    private List<Task> authoredTasks;

    @ManyToMany
    @JoinTable(name = "tasks_executors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> executingTasks;

    public String getId() { return id; }

    // PreAuthorized()
    public List<Task> getAuthoredTasks() { return authoredTasks; }

    public List<Task> getExecutingTasks() { return executingTasks; }
}
