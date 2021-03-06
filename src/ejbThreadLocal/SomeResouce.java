package ejbThreadLocal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/myResource")
public class SomeResouce {
	@Inject TopLevelEjbWithContext myEjb;
	
	@Produces({ "text/plain" })
	@GET
	public Response getMeSomeKindOfData(@QueryParam("id") String id){
		return Response.status(200).entity(myEjb.executeWork(id)).build();
	}
}
