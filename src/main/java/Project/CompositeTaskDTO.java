package Project;

import java.util.Set;


/**
 * Created by user on 15.02.2018.
 */
public class CompositeTaskDTO {
    Task task;
    Set<Task> subTasks;

    public CompositeTaskDTO(TaskTree taskTree) {
        task = taskTree.getHead();
        subTasks = taskTree.getHierarchy().getChildren(task);
    }


    @Override
    public String toString() {
        return "CompositeTaskDTO{" +
                "task=" + task +
                ", subTasks=" + subTasks +
                '}';
    }
}