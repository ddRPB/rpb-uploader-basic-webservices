package de.dktk.dd.rpb.uploaderbasicwebservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("/pacs/rpbUploader.faces")
public class HelloResourceTwo {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("api-key", "dummy-api-key");
        return jsonObject.toString();
    }
}