package com.vrushank.jaxb.jaxbxjc;

import com.vrushank.patient.Patient;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication*/
public class JaxbxjcApplication {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();

			Patient patient = new Patient();
			patient.setId(159);
			patient.setName("vrp pat");
			patient.setAge(20);

			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(patient,stringWriter);

			System.out.println(stringWriter.toString());

			Unmarshaller unmarshaller = context.createUnmarshaller();

			Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(stringWriter.toString()));

			System.out.println(patientResult.getAge() + "  " + patientResult.getName() + "  " + patientResult.getId());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
