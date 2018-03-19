package Project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonAutoDetect
public class TaskDTO {
    public String name;

    public String executor;

@JsonCreator
        TaskDTO(){}
     TaskDTO(@JsonProperty("executor")  String executor, @JsonProperty("name")  String name) {
         this.name = name;
        this.executor = executor;
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