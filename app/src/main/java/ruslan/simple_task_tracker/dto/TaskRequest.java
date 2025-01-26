package ruslan.simple_task_tracker.dto;

import ruslan.simple_task_tracker.persistence.entities.main.TaskPriority;
import ruslan.simple_task_tracker.persistence.entities.main.TaskStatus;

import java.util.List;

public class TaskRequest {

    /*
        This class means: Look for k tasks where task (
            (matches any header regex) &&
            (matches any status) &&
            (has any of given priority) && and so on
            ).
        If any field is null (except marked as mandatory), it won't be used in scanning
    */

    private int k; // Mandatory
    private List<String> headerRegexes; // if null
    private List<TaskStatus> status; // < 3
    private List<TaskPriority> priorities; //
    private String author;
    private List<List<String>> executors;
}
