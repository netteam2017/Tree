package Project;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/myresource")

public class MyResource {
    TaskManager taskManager = new TaskManager(new Node(new Id()));
    TaskTree taskTree = new TaskTree("headTask", "Kate");

    public MyResource() {
        Task task2 = taskTree.addTask("subTask", "executor2", taskTree.getHead());
        taskTree.addTask("subsubTask", "3", task2);
    }

    @GET
    @Path("/task/{taskName}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(@PathParam("taskName") String name) {
        System.out.print(name);


        //Task task = taskTree.getHead();
       // System.out.print(taskTree.getNodeMap());
        CompositeTaskDTO compositeTaskDTO = new CompositeTaskDTO(taskTree,"create tasktreenamemethod"); //(task, taskTree.getNodeMap());

        return compositeTaskDTO;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTask(TaskDTO taskDTO) {
        ObjectMapper om = new ObjectMapper();
       // Id id = om.readValues(taskDTO.)
        taskTree.updateTask(taskDTO.task.getId(), taskDTO.task.name);
    }

    private Id parseId(String taskId){
        int h = 0;
        int n = 0;
        String s_h = "";
        String s_n = "";
        int k = 0;
        for (int i=0; i < taskId.length(); i++) {
            char c = taskId.charAt(i);
            if (c < '0' || c > '9') {
                k=i;
                break;
            }
            s_h = s_h + c;
        }
        for (int i = k+1; i < taskId.length();i++){
            char c = taskId.charAt(i);
            if (c < '0' || c > '9') continue;
            s_n=s_n+c;
        }
        h = Integer.parseInt(s_h);
        n = Integer.parseInt(s_n);
        Id newTaskId = new Id(h,n);
        return newTaskId;
    }

   // проиденскировать айди(через мэп) проверить ниже.
    @DELETE
    @Path("/delete/{taskId}/{taskName}") //два параметра
    public void deleteTask(@PathParam("taskId") String taskId,@PathParam("taskName") String taskName) throws IOException{
        ObjectMapper om = new ObjectMapper();
        System.out.print(taskId+taskName);
        Id id = om.readValue(taskId,Id.class);
        taskTree.deleteTask(id);
    }


    @POST
    @Path("/create") //сделать так чтобы возвращал строку.
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createTask(TaskDTO taskDTO) throws IOException {
        ObjectMapper om = new ObjectMapper();
        Id id = om.readValue(taskDTO.parentId.toString(),Id.class);
        taskTree.addTask(taskDTO.task.getExecutor(), taskDTO.task.getName(), taskTree.getTask(id));
        return taskDTO.parentId.toString();
    }
}
