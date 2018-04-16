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
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/myresource")

public class MyResource  {
    TaskManager taskManager = new TaskManager(new Node(new Id()));
    TaskTree taskTree = new TaskTree("1","1");
    @GET
    @Path("/task/{taskName}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(@PathParam("taskName") String name) {
       // System.out.print(name);



        Task task = taskTree.getTaskOnName(name);
        CompositeTaskDTO compositeTaskDTO = new CompositeTaskDTO(task,taskTree.getHierarchy().getChildren(task));

        return compositeTaskDTO;
    }
  // TaskDTO taskDTO = new TaskDTO(new Task("k","newname",new Id()),new Id(1,1),"newTree");
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public void updateTask( TaskDTO taskDTO) {
         taskDTO = new TaskDTO(new Task("k","newname",new Id()),new Id(1,1),"newTree");
         taskTree.updateTask(taskDTO.task.getId(),taskDTO.task.name);
        /////////////////traves
    }

    @POST
    @Path("/delete") //вот этот еще не работает я скину чуть позже
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteTask(String taskTreename, Id taskId) {
        taskTree.deleteTask(taskId);
    }


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTask(TaskDTO taskDTO) {

        taskTree.addTask(taskDTO.task.getExecutor(),taskDTO.task.getName(),taskTree.getTask(taskDTO.parentId));
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

