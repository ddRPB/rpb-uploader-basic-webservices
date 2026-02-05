package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/pacs")
public class ConnectResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rpbUploader.faces")
    public String connect() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("apiKey", "dummy-api-key");
        return jsonObject.toString();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/dicomPatientStudies.faces")
    public Response redirectPortal(@Context HttpHeaders headers) {
        return Response.status(200).entity("<h1>There is no portal to redirect to. Please return to the previous page to upload more files.</h1>").build();
    }
}