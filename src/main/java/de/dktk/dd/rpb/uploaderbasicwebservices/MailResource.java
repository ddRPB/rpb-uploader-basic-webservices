package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/adminmail")
public class MailResource {

    @POST
    public Response sendMail(@Context HttpHeaders headers) {
        return Response.status(200).build();
    }
}
