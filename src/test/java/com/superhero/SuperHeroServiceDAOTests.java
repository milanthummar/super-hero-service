package com.superhero;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.dao.SuperHeroServiceDAO;
import com.superhero.pojo.Allies;
import com.superhero.pojo.Skills;
import com.superhero.pojo.Superhero;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SuperHeroServiceApplicationConfig.class })
public class SuperHeroServiceDAOTests {

	@Autowired
	private SuperHeroServiceDAO superHeroServiceDAO;
	
	@Test
	public void createSuperHero() {
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
		
		expect(superHeroServiceDAO.createSuperHero(EasyMock.anyObject(Superhero.class))).andReturn(true).once();
		replay(superHeroServiceDAO);
		
		boolean acknowledgement = superHeroServiceDAO.createSuperHero(EasyMock.anyObject(Superhero.class));
		
		assertEquals(acknowledgement, true);
		
		
	}
	
	@Test
	public void getAllSuperHero() {
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
		
		expect(superHeroServiceDAO.getAllSuperHero()).andReturn(superheros).once();
		replay(superHeroServiceDAO);
		
		List<Superhero> superherosReturn = superHeroServiceDAO.getAllSuperHero();
		
		assertNotNull(superherosReturn);
		assertEquals(superherosReturn.get(0).getName(), "Superman");
		
		
	}

	@Test
	public void getSuperHero() {
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
		
		
		expect(superHeroServiceDAO.getSuperHero(EasyMock.anyObject(String.class))).andReturn(superhero).once();
		replay(superHeroServiceDAO);
		
		Superhero superheroReturn = superHeroServiceDAO.getSuperHero(EasyMock.anyObject(String.class));
		
		assertNotNull(superheroReturn);
		assertEquals(superheroReturn.getName(), "Superman");
		
		
	}
	
}
