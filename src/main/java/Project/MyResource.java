package Project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    TaskManager taskManager = new TaskManager(new Node(new Id()));

    @GET
    @Path("/task")
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(String name) {
        Task task = taskManager.getTaskOnName(name);
        CompositeTaskDTO compositeTaskDTO = new CompositeTaskDTO(task,taskManager.getHierarchy().getChildren(task));
        return compositeTaskDTO;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
