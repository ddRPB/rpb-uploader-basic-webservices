package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import jakarta.mail.internet.MimeMultipart;

import java.io.IOException;

@Path("/api/v1/dicomweb")
public class DicomwebResource {

    @POST
    @Path("/studies/{dicomStudyIdentifier}")
    @Consumes("multipart/related")
    public Response storeDicomStudy(@Context HttpHeaders headers,
                                    @PathParam("dicomStudyIdentifier") String dicomStudyIdentifier,
                                    MimeMultipart multi){

        return Response.status(200).build();
    }


}
