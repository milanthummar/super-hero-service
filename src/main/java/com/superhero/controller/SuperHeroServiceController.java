package com.superhero.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.pojo.Superhero;
import com.superhero.service.SuperHeroServiceService;

@RestController
@RequestMapping("/superheroservice/")
public class SuperHeroServiceController {

	private static final Logger CONTROLLER = Logger.getLogger(SuperHeroServiceController.class);

	@Autowired
	private SuperHeroServiceService superHeroServiceService;

	@RequestMapping(value = "/createsuperhero", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createSuperHero(@RequestBody Superhero superhero) {

		if (superHeroServiceService.createSuperHero(superhero)) {
			CONTROLLER.info("Super Hero Successfully added");
			return "Super Hero Successfully added";
		} else {
			CONTROLLER.error("Super Hero addition has been failed");
			return "Super Hero addition has been failed";
		}

	}

	@RequestMapping(value = "/getallsuperhero", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Superhero> getAllSuperHero() {

		return superHeroServiceService.getAllSuperHero();

	}

	@RequestMapping(value = "/getsuperhero/{superheroname}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Superhero getSuperHero(@PathVariable String superheroname) {

		System.out.println(superHeroServiceService.getSuperHero(superheroname).getName());
		
		return superHeroServiceService.getSuperHero(superheroname);

	}

}
