package com.example.patient.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.patient.controller.PatientController;
import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	
	  @MockBean
	  private PatientRepository patientRepository;
	  
	  @MockBean
	  private PatientService patientService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Patient patient=new Patient(1, "swe", "giri", "22-08-2022","general",
				1);

	    mockMvc.perform(post("/patients/").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(patient)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=1;
	    String name="swe";
	    Patient patient=new Patient(id, "swe", "giri", "22-08-2022","general",
				1);

	   //hen(patientRepository.findById(id).thenReturn(Optional.of(patient).get()));
	    //en(doctorRepository.findById(id)).thenReturn(Optional.of(doctor));
	    mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
	        /*.andExpect(jsonPath("$.id").value(id))
	        .andExpect(jsonPath("$.name").value(name))
	        .andExpect(jsonPath("$.gender").value(doctor.getGender()))
	        .andExpect(jsonPath("$.specialist").value(doctor.getSpecialist()))
	        .andExpect(jsonPath("$.numberOfPatients").value(doctor.getNumberOfPatients()))
	        .andExpect(jsonPath("$.age").value(doctor.getAge()))
	        .andExpect(status().isOk())*/
	        .andDo(print());
	  }
	  

	  /*@Test
	  void shouldReturnNotFoundTutorial() throws Exception {
	    long id = 1L;

	    when(tutorialRepository.findById(id)).thenReturn(Optional.empty());
	    mockMvc.perform(get("/api/tutorials/{id}", id))
	         .andExpect(status().isNotFound())
	         .andDo(print());
	  }*/

	 /*Test
	  void shouldReturnListOfDoctors() throws Exception {
		  List<Patient> patients= new ArrayList<>(
			        Arrays.asList(new Patient(1,"Mona", "Dr.Mona", "22-06-2022","Thyronorm",
						1),
			            new Patient(2,"Sona", "Dr.Mona", "22-06-2022","Thyronorm",
						1),
			            new Patient(3,"Dona", "Dr.Mona", "22-06-2022","Thyronorm",
						1)));

			    when(patientRepository.findAll()).thenReturn(patients);
			    mockMvc.perform(get("/api/tutorials ))
			        .andExpect(status().isOk())
			       //andExpect(jsonPath("$.size()").value(patients.size()))
			        .andDo(print());*/
	  

}

