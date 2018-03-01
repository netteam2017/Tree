package com.nc.tree;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

  /* @GET
    @Path("task")
    @Produces(MediaType.APPLICATION_JSON)
    public CompositeTaskDTO getTaskTree(String name) {

        //Gson gson = new Gson();
        // CompositeTaskDTO json = gson.toJson(taskManager.getTask(name));
        return new CompositeTaskDTO(new TaskTree(new Task("1","2",new Id(1,1))));
    }*/

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("it")
    public String getIt() {
        return "hello";
    }
}
