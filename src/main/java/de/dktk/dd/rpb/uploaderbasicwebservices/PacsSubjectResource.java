package de.dktk.dd.rpb.uploaderbasicwebservices;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/v1/pacs")
public class PacsSubjectResource {

    @Inject private Counter counter;

    @GET
    @Path("/subjects/{subjectid}/studies/{study}/series/{series}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDicomSeriesData(@Context HttpHeaders headers,
                                       @PathParam("subjectid") String dicomPatientId,
                                       @PathParam("study") String studyInstanceUid,
                                       @PathParam("series") String seriesInstanceUid){

        int count;
        List<String> imageArray = new ArrayList<>();

        if(this.counter.hasUID(seriesInstanceUid)){
            count = this.counter.getCount(seriesInstanceUid);
            for(int i = 0; i < count; i++) {
                imageArray.add(seriesInstanceUid);
            }
            this.counter.removeUID(seriesInstanceUid);
        }

        Map<String,List> seriesImages = new HashMap<>();
        seriesImages.put("Images",imageArray);

        List<Map> seriesData = new ArrayList<>();
        seriesData.add(seriesImages);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Series", seriesData);

        return Response.status(200).entity(jsonObject.toString()).build();
    }

}
