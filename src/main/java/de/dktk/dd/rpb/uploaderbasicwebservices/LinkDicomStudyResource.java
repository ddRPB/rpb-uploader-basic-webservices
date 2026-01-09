package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Path("/api/v1/edc")
public class LinkDicomStudyResource {

    @POST
    @Path("/linkdicomstudy")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateDicomUids(@Context HttpHeaders headers) {

        JSONObject jsonObj = new JSONObject();
        return Response.status(200).entity(jsonObj.toString()).build();
    }
}
