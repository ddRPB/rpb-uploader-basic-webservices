package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/pacs")
public class PacsSubjectResource {

    @GET
    @Path("/subjects/{subjectid}/studies/{study}/series/{series}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDicomSeriesData(@Context HttpHeaders headers,
                                       @PathParam("subjectid") String dicomPatientId,
                                       @PathParam("study") String studyInstanceUid,
                                       @PathParam("series") String seriesInstanceUid){
        //return Response.ok().build();
        return jakarta.ws.rs.core.Response.status(200).entity("28").build();
    }

}
