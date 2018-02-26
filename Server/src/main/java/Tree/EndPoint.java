package Tree;

import com.google.gson.Gson;
import com.nc.tree.Id;
import com.nc.tree.Task;
import com.nc.tree.TaskManager;
import com.nc.tree.WriteRead;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by user on 01.02.2018.
 */
@Path("endpoint")
public class EndPoint extends HttpServlet {

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
    @Produces() {
        // public String getAllTasks() { //нет метода
        //   return taskManager.getAllTasks();
    }

    @GET
    @Path("/task")
    public String getTask(Id id) {
        Gson gson = new Gson();
        String json = gson.toJson(taskManager.getTask(id));
        return json;
    }

    @DELETE
    @Path("/deletetask")
    public void deleteTask(Id id) {
        taskManager.deleteTask(id);

    }

    @POST
    @Path("/update")
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int height = Integer.parseInt(req.getParameter("height"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        String name = req.getParameter("name");

        taskManager.updateTask(new Id(height, weight), name);
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Hello, world! или Привет мир</H1>");

    }

    public void updateTask() {

    }

    @POST
    @Path("/updatetime")
    public void updateSpentTime() { // method is not exist

    }
}
