package Project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.DataOutput;
import java.io.Serializable;
import java.util.Set;


/**
 * Created by user on 15.02.2018.
 */

public class CompositeTaskDTO implements Serializable {
    public Task task;
    public Set<Task> subTasks;

    @JsonCreator
    public CompositeTaskDTO() {
    }


    public CompositeTaskDTO( Task task,Set<Task> subTasks) {
        this.task = task;
        this.subTasks = subTasks;
    }

}
   /* public  Set<Task>getSubTasks()
    {
        return subTasks;
    }
}
/*
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class CompositeTaskDTO implements Serializable {


    Task task;
    Set<Task> subTasks;

    public CompositeTaskDTO() {
    }

    @JsonCreator
    public CompositeTaskDTO(Task task,Set<Task> subTasks) {
        @
        this.task=task;
        this.subTasks = subTasks;
    }
    @JsonProperty
    public Task getTask(){
        return this.task;
    }
    @JsonProperty
    public void setTask(Task task){
        this.task=task;
    }
    @JsonProperty
    public Set<Task> getSubTasks(){
        return this.subTasks;
    }
    @JsonProperty
    public void setSubTasks(Set<Task> subTasks){
        this.subTasks=subTasks;
    }


    @Override
    public String toString() {
        return "CompositeTaskDTO{" +
                "task=" + task +
                ", subTasks=" + subTasks +
                '}';
    }
}
*/