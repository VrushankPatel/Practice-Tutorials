package com.vrushank.restws;

import com.vrushank.restws.model.Patient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService{
    Map<Long, Patient> patients = new HashMap<Long, Patient>();
    long currentId = 123;
    public PatientServiceImpl() {
        init();
    }

    void init(){
        Patient patient = new Patient();
        patient.setId(currentId);
        patient.setName("Steve Jobs");
        patients.put(patient.getId(), patient);
    }

    @Override
    public List<Patient> getPatients() {
        Collection<Patient> results = this.patients.values();
        List<Patient> response = new ArrayList<>(results);
        return response;
    }
}
