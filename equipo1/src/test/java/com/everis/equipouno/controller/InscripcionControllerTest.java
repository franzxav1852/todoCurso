package com.everis.equipouno.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.everis.equipouno.Application;
import com.everis.equipouno.model.Inscripcion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class InscripcionControllerTest {
	
	private MockMvc  mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mvc =MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testListar() throws Exception {
		String url = "/inscripcion/";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status ==200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<Inscripcion> inscripciones = mapper.readValue(jsonRespuesta, new TypeReference<List<Inscripcion>>() {
		});
		assertNotNull(inscripciones);
		assertTrue(inscripciones.size() >0);
		for (Inscripcion inscripcion: inscripciones) {
			assertTrue(inscripcion.getAlumno() != null);
			
		}
	}
	
//	@Test
//	public void testInsertar() throws Exception {
//		String url = "/inscripcion/";
//		Inscripcion inscripcion = new Inscripcion();
//		inscripcion.setAlumno;
//		inscripcion.setCalendario();
//		//Jaxkson
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(inscripcion);
//		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url)
//				.content(MediaType.APPLICATION_JSON_VALUE)
//				.content(json)).andReturn();
//		int status = resultado.getResponse().getStatus();
//		assertTrue(status == 200); //Exitosa la peticion
//		String jsonRespuesta = resultado.getResponse().getContentAsString();
//		Inscripcion inscripcionInsertada = mapper.readValue(jsonRespuesta, Inscripcion.class);
//		assertTrue(inscripcionInsertada.getId() > 0);
//		//assertTrue(jsonRespuesta.contains("id"));
//	}
//	
//	@Test
//	public void testActualizar() throws Exception {
//		String url = "/inscripcion/";
//		Inscripcion inscripcion = new Inscripcion();
//		inscripcion.setId(2);
//		inscripcion.setAlumno("Inscripcion Actualizada");
//		inscripcion.setPagos("pago actualizado");
//		//Jaxkson
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(inscripcion);
//		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url)
//				.content(MediaType.APPLICATION_JSON_VALUE)
//				.content(json)).andReturn();
//		int status = resultado.getResponse().getStatus();
//		assertTrue(status == 200); //Exitosa la peticion
//		String jsonRespuesta = resultado.getResponse().getContentAsString();
//		Inscripcion inscripcionActualizada = mapper.readValue(jsonRespuesta, Inscripcion.class);
//		assertTrue(inscripcionActualizada.getId() > 0);
//		//assertTrue(jsonRespuesta.contains("id"));
//	}
//	
	
	
		
	
}

