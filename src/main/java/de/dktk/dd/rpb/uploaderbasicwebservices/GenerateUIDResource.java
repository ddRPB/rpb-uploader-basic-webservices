package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

//import org.dcm4che.util.UIDUtils;

import java.util.ArrayList;
import java.util.List;

@Path("/api/v1/pacs/generateuids")
public class GenerateUIDResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateDicomUids(@Context HttpHeaders headers,
                                      @QueryParam("orgroot") String orgRootPrefix,
                                      @QueryParam("count") Integer count) {


        if (orgRootPrefix == null) {
            orgRootPrefix = "2.25";
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
                //uidList.add(UIDUtils.createUID(orgRootPrefix));
                uidList.add("0");
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
}
