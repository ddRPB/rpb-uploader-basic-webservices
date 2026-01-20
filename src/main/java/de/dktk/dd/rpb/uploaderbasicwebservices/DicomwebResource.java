package de.dktk.dd.rpb.uploaderbasicwebservices;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import de.dktk.dd.rpb.uploaderbasicwebservices.util.ICounter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;

import java.io.IOException;
import java.util.List;

@Path("/api/v1/dicomweb")
public class DicomwebResource {

    //@Inject private Counter counter;
    private Counter counter = new Counter();

    @POST
    @Path("/studies/{dicomStudyIdentifier}")
    @Consumes({"multipart/mixed","multipart/related", "multipart/*"})
    public Response storeDicomStudy(@Context HttpHeaders headers,
                                    @PathParam("dicomStudyIdentifier") String dicomStudyIdentifier,
                                    MultiPart multipart) throws IOException {


        List<BodyPart> parts = multipart.getBodyParts();
        this.counter.setCount(this.counter.getCount() + parts.size());
        System.out.println("count: " + this.counter.getCount());

        return Response.status(200).build();
    }


}
