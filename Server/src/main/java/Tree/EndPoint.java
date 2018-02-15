package Tree;

import com.nc.tree.Id;
import com.nc.tree.Task;
import com.nc.tree.TaskManager;
import com.nc.tree.WriteRead;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by user on 01.02.2018.
 */
@Path("endpoint")
public class EndPoint {

    WriteRead writeRead;
    TaskManager taskManager;

    public EndPoint(Task task) {
        WriteRead writeRead = new WriteRead();
        TaskManager taskManager = new TaskManager(task);

    }

    //коснтруктор написать, вызов классов врайт рд и класс с задачами.
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Task getIt(Id id) { //нет метода
        return taskManager.getTask(id);

    }

    @GET
    @Path("/alltasks")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllTasks() { //нет метода
        return taskManager.getAllTasks();
    }

    @GET
    @Path("/task")
    public Task getTask(Id id) {
        return taskManager.getTask(id);

    }

    @DELETE
    @Path("/deletetask")
    public void deleteTask(Id id) {
        taskManager.deleteTask(id);

    }

    @POST
    @Path("/update")
    public void updateTask(Id id, String newName) {

        taskManager.updateTask(id, newName);
    }

    @POST
    @Path("/updatetime")
    public void updateSpentTime() { // method is not exist

    }
}
