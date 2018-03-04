package Project;

/**
 * Created by user on 15.02.2018.
 */
public class TaskDTO {
    public Task task;
    public Id parentId;
    public String taskTreeName;

    public TaskDTO(Task task, Id parentId, String taskTreeName) {
        this.task = task;
        this.parentId = parentId;
        this.taskTreeName = taskTreeName;
    }

}
