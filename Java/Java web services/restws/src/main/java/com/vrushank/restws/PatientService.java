package com.vrushank.restws;

import com.vrushank.restws.model.Patient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/patientservice")
public interface PatientService {
    @Path("/patients")
    @GET
    List<Patient> getPatients();
}
