package Tree;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by user on 01.02.2018.
 */
@Path("endpoint")
public class EndPoint {

    //коснтруктор написать, вызов классов врайт рд и класс с задачами.
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "hello111";
    }

    @GET
    @Path("/alltasks")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllTasks() {
        return "alltasks";
    }

    @GET
    @Path("/task")
    public void getTask() {

    }

    @DELETE
    @Path("/deletetask")
    public void deleteTask() {

    }

    @POST
    @Path("/update")
    public void updateTask() {

    }

    @POST
    @Path("/updatetime")
    public void updateSpentTime() {

    }
}
