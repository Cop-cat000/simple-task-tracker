package ruslan.simple_task_tracker.persistence.entities.main;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String header;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "author")
    private MainUser author;

    @ManyToMany(mappedBy = "executingTasks", cascade = CascadeType.REMOVE)
    private List<MainUser> executors;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "task_details")
    private TaskDetails details;


    public int getId() { return id; }

    public String getHeader() { return header; }
    public void setHeader(String header) { this.header = header; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public TaskPriority getPriority() { return priority; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }

    public MainUser getAuthor() { return author; }
    public void setAuthor(MainUser author) { this.author = author; }

    public List<MainUser> getExecutors() { return executors; }
    public void setExecutors(List<MainUser> executors) { this.executors = executors; }

    public TaskDetails getDetails() { return details; }
    public void setDetails(TaskDetails details) { this.details = details; }
}
