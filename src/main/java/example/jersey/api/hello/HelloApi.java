package example.jersey.api.hello;

import example.jersey.serviceImpl.HelloAdapter;
import example.jersey.serviceImpl.HelloApiServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/")
public class HelloApi  {

    @Inject
    private HelloAdapter adapter;
    private final HelloApiService delegate = new HelloApiServiceImpl();

    @GET
    @Path("/hello/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response retrieveAlarmList( @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.retrieveGreets(securityContext, adapter);
    }
}
