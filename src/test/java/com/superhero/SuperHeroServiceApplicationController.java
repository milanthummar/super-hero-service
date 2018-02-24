package com.superhero;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.superhero.controller.SuperHeroServiceController;
import com.superhero.pojo.Allies;
import com.superhero.pojo.Skills;
import com.superhero.pojo.Superhero;
import com.superhero.service.SuperHeroServiceService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SuperHeroServiceApplicationController {

	@Mock
	SuperHeroServiceService superHeroServiceService;

	MockMvc mockMvc;

	@InjectMocks
	SuperHeroServiceController superHeroServiceController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(superHeroServiceController).build();

	}

	@Test
	public void createSuperHero() throws Exception {

		String superHeroString = "{\"name\":\"Padman\",\"pseudonym\":\"Padman\",\"publisher\":\"Indian Comic\",\"skills\":[{\"skill\":\"Women Empowerment\"}],\"allies\":[{\"alliesWith\":\"Pari\"}],\"first_appearance\":\"14th Nov 2018\"}";

		Mockito.when(superHeroServiceService.createSuperHero(Mockito.any(Superhero.class))).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/superheroservice/getallsuperhero")
				.accept(MediaType.APPLICATION_JSON).content(superHeroString).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		assertEquals("Super Hero Successfully added", mvcResult.getResponse().getContentAsString());

	}

	@Test
	public void getAllSuperHero() throws Exception {

		Superhero superhero = new Superhero();
		superhero.setName("Superman");
		superhero.setFirst_appearance("1978");
		superhero.setPseudonym("Superman");
		superhero.setPublisher("DC");
		
		
		Skills skills = new Skills();
		skills.setSkill("Can Fly");
		
		Allies allies = new Allies();
		allies.setAlliesWith("Batman");
		
		superhero.getAllies().add(allies);
		superhero.getSkills().add(skills);
		
		List<Superhero> superheros = new ArrayList<Superhero>();
		superheros.add(superhero);
		
		Mockito.when(superHeroServiceService.getAllSuperHero()).thenReturn(superheros);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/superheroservice/getallsuperhero")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(mvcResult.getResponse().getHeaderNames());
		
		assertEquals("200", String.valueOf(mvcResult.getResponse().getStatus()));

	}

	@Test
	public void getSuperHero() throws Exception {

		Superhero superhero = new Superhero();
		superhero.setName("Superman");
		superhero.setFirst_appearance("1978");
		superhero.setPseudonym("Superman");
		superhero.setPublisher("DC");
		
		
		Skills skills = new Skills();
		skills.setSkill("Can Fly");
		
		Allies allies = new Allies();
		allies.setAlliesWith("Batman");
		
		superhero.getAllies().add(allies);
		superhero.getSkills().add(skills);
		
		
		Mockito.when(superHeroServiceService.getSuperHero(EasyMock.anyObject(String.class))).thenReturn(superhero);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/superheroservice/getallsuperhero")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(mvcResult.getResponse().getHeaderNames());
		
		assertEquals("200", String.valueOf(mvcResult.getResponse().getStatus()));

	}

}
