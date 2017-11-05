package localnode;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/localhashtable")
@Produces(MediaType.APPLICATION_JSON)
public class LocalNodeResource {
    public LocalNodeResource() {

    }

    @GET
    @Path("/{key}")
    public String getValue(@PathParam("key") int key) {
        return String.valueOf(LocalNodeBL.get(key));
    }

    @PUT
    @Path("/{key}")
    public String putValue(@PathParam("key") int key, @QueryParam("value") String value) {
        return String.valueOf(LocalNodeBL.put(key, value));
    }
}
