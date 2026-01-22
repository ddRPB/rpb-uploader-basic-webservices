package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.enterprise.inject.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;


@Path("/pacs/dicomPatientStudies.faces")
public class RedirectResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response redirectPortal(@Context HttpHeaders headers) {
        return Response.status(200).entity("<h1>There is no portal to redirect to. Please return to the previous page to upload more files.</h1>").build();
    }
}
