package com.nc.tree;

/**
 * Created by user on 01.03.2018.
 */
public class DtoConverter {
    TaskDTO taskDTO;
    CompositeTaskDTO compositeTaskDTO;

    public DtoConverter(Task task, TaskTree taskTree) {
        //taskDTO.taskTreeName=taskTree.name;
        taskDTO.task = task;
        taskDTO.parentId = taskTree.getHierarchy().getParent(task).getId();
        compositeTaskDTO = new CompositeTaskDTO(taskTree);
    }

    public TaskDTO getTaskDTO() {
        return taskDTO;
    }

    public CompositeTaskDTO getCompositeTaskDTO() {
        return compositeTaskDTO;
    }
}
