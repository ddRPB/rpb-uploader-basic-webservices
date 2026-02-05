package de.dktk.dd.rpb.uploaderbasicwebservices;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.dcm4che3.util.UIDUtils;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/v1/pacs")
public class PacsResource {

    @Inject
    private Counter counter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generateuids")
    public Response generateDicomUids(@Context HttpHeaders headers,
                                      @QueryParam("orgroot") String orgRootPrefix,
                                      @QueryParam("count") Integer count) {


        if (orgRootPrefix == null) {
            orgRootPrefix = "1.25";
        }

        if (count == null) {
            count = 10;
        } else if (count > 10000) {
            // limit
            count = 10000;

        }

        List<String> uidList = new ArrayList<>();

        try {
            for (int i = 0; i < count; i++) {
                uidList.add(UIDUtils.createUID(orgRootPrefix));
            }
        } catch (Exception err) {
            return Response.status(500).build();
        }

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("uidList", uidList);
            jsonObj.put("count", count);
        } catch (JSONException err) {
            return Response.status(500).build();
        }

        return Response.status(200).entity(jsonObj.toString()).build();
    }

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

        Map<String,List<String>> seriesImages = new HashMap<>();
        seriesImages.put("Images",imageArray);

        List<Map<String,List<String>>> seriesData = new ArrayList<>();
        seriesData.add(seriesImages);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Series", seriesData);

        return Response.status(200).entity(jsonObject.toString()).build();
    }
}
