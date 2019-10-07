package com.everis.equipouno.controller;

import static org.junit.Assert.*;

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
import com.everis.equipouno.model.Curso;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//JUnit para Spring Boot
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CursoControllerTest {
	
	//Mock es un objeto de prueba (dummie) simulación de peticiones y respuestas http
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
	}
	
	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertar() throws Exception {
		String url = "/curso/";
		Curso curso = new Curso();
		curso.setNombrecurso("Curso Alejandro Junit");
		curso.setDescripcion("Descripcion Alejandro Junit");
		//Usando Jackson
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(curso);
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200); //Exitosa la peticion
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		assertTrue(jsonRespuesta.contains("id"));
	}

}
