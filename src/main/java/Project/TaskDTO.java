package Project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

public class TaskDTO implements Serializable {
    public Task task;
    public Id parentId;
    public String taskTreeName;

@JsonCreator
        TaskDTO(){}
     TaskDTO(@JsonProperty("task") Task task, @JsonProperty("parentId") Id parentId, @JsonProperty("taskTreeName") String taskTreeName) {
         this.task=task;
         this.parentId=parentId;
         this.taskTreeName=taskTreeName;
    }




   /* public void setName(String name) {
        this.name = name;
    }

    public void setSpentTime(long spentTime) {
        this.spentTime = spentTime;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public void setStatus(Status status) {
        this.status = status;
    }*/
}