package de.dktk.dd.rpb.uploaderbasicwebservices;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.MultiPart;

import java.io.*;
import java.util.List;

import org.apache.commons.io.IOUtils;

@Path("/api/v1/dicomweb")
public class DicomwebResource {

    @Inject private Counter counter;

    @POST
    @Path("/studies/{dicomStudyIdentifier}")
    @Consumes({"multipart/mixed","multipart/related", "multipart/*"})
    public Response storeDicomStudy(@Context HttpHeaders headers,
                                    @PathParam("dicomStudyIdentifier") String dicomStudyIdentifier,
                                    MultiPart multipart) throws IOException {


        List<BodyPart> parts = multipart.getBodyParts();
        for (BodyPart part : parts) {
            // Read DICOM
            Attributes dcmAttributes = null;
            DicomInputStream din = null;
            Object value = part.getEntity();

            // One input for DICOM reader
            InputStream dis = new ByteArrayInputStream(IOUtils.toByteArray(((BodyPartEntity)value).getInputStream()));

            din = new DicomInputStream(dis);
            dcmAttributes = din.readDataset(-1, -1);

            if (din != null) {
                din.close();
            }

            String seriesUID = dcmAttributes.getString(Tag.SeriesInstanceUID);
            if(this.counter.hasUID(seriesUID) == true){
                int currentCount = this.counter.getCount(seriesUID);
                this.counter.addUID(seriesUID, currentCount + 1);
            }
            else{
                this.counter.addUID(seriesUID, 1);
            }
        }

        return Response.status(200).build();
    }


}
