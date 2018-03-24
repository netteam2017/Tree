package Project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.faces.annotation.RequestMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/MyResource")

public class MyResource extends HttpServlet {
    TaskManager taskManager = new TaskManager(new Node(new Id()));

    @GET
    @Path("/task")
    @Consumes(MediaType.TEXT_HTML)

    @Produces(MediaType.APPLICATION_JSON)

    public CompositeTaskDTO getTaskTree(String name) {
        System.out.print(name);

        TaskTree taskTree = new TaskTree("1","1");

        Task task = taskTree.getTaskOnName("1");
        CompositeTaskDTO compositeTaskDTO = new CompositeTaskDTO(task,taskTree.getHierarchy().getChildren(task));

        return compositeTaskDTO;
    }

    @POST
    @Path("/create")
    public void createTask(TaskDTO taskDTO){

        taskManager.addTask(taskDTO.task.getExecutor(),taskDTO.task.getName(),taskDTO.parentId);
    }

    @POST
    @Path("/update")
    public void updateTask(TaskDTO taskDTO){
        taskManager.updateTask(taskDTO.task.getId(),taskDTO.taskTreeName);
    }
    @POST
    @Path("/delete")
    public void deleteTask(String taskTreename, Id taskId){
        taskManager.deleteTask(taskId);
    }
    /*
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String varTextA = "Hello World!";
        request.setAttribute("textA", varTextA);
        String varTextB = "It JSP.";
        request.setAttribute("textB", varTextB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
        dispatcher.forward(request, response);
    }*/
}
   /* @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    return "hi";
    }*/

