package Tree;

//import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Created by user on 01.02.2018.
 */
@Path("myresource2")
public class MyResource2 {

    // WriteRead writeRead;
    // TaskManager taskManager;

/*    public MyResource2(*//*Task task,String name*//*) {
        WriteRead writeRead = new WriteRead();
        TaskManager taskManager = new TaskManager(task);
        TaskDTO taskDTO = new TaskDTO(task,taskManager.getHierarchy().getParent(task).getId(),name);
        System.out.print("111");

    }*/

   /* @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Task getIt(Id id) { //нет метода
        return taskManager.getTask(id);

    }
*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "hello";
    }

/*    @GET
    @Path("/task")
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(String name) {

        //Gson gson = new Gson();
       // CompositeTaskDTO json = gson.toJson(taskManager.getTask(name));
        return new CompositeTaskDTO(new TaskTree(new Task("1","2",new Id(1,1))));
    }*/

 /*   @DELETE
    @Path("/deletetask")
    public void deleteTask(Id id) {
        taskManager.deleteTask(id);

    }*/

    /*@POST
    @Path("/update")
    public void updateTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int height = Integer.parseInt(req.getParameter("height"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        String name = req.getParameter("name");

        taskManager.updateTask(new Id(height, weight), name);
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Hello, world!</H1>");

    }*/

/*    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTask(TaskDTO taskDTO){
        System.out.println(taskDTO.task.getData());
    }*/


}
