package com.fourtkb.appointmentservice.client;

import com.fourtkb.appointmentservice.client.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("patient-service")
public interface PatientFeignClient {

    @RequestMapping(method = RequestMethod.GET,value ="v1/patients/{patientId}", consumes = "application/json")
    PatientDTO getPatientDTOById(@PathVariable("patientId") String patientId);

}
