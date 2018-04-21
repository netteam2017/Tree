package Project;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/myresource")

public class MyResource {
    TaskManager taskManager = new TaskManager(new Node(new Id()));
    TaskTree taskTree = new TaskTree("1", "1");

    public MyResource() {
        taskTree.addTask("2", "2", taskTree.getHead());
        taskTree.addTask("3", "3", taskTree.getTaskOnName("2"));
    }

    @GET
    @Path("/task/{taskName}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(@PathParam("taskName") String name) {
        System.out.print(name);


        Task task = taskTree.getTaskOnName(name);
        CompositeTaskDTO compositeTaskDTO = new CompositeTaskDTO(task, taskTree.getHierarchy().getChildren(task));

        return compositeTaskDTO;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTask(TaskDTO taskDTO) {
        taskTree.updateTask(taskDTO.task.getId(), taskDTO.task.name);
    }

    @DELETE
    @Path("/{taskTreeName}/{taskId}")
    public void deleteTask(@PathParam("taskTreeName") String taskId) {
        taskTree.deleteTask(taskTree.parseId(taskId));
    }


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTask(TaskDTO taskDTO) {
        taskTree.addTask(taskDTO.task.getExecutor(), taskDTO.task.getName(), taskTree.getTask(taskDTO.parentId));
    }
}
