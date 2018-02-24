package com.superhero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.dao.SuperHeroServiceDAO;
import com.superhero.pojo.Superhero;

@Service
public class SuperHeroServiceService {

	@Autowired
	private SuperHeroServiceDAO superHeroServiceDAO;

	public boolean createSuperHero(Superhero superhero) {
		return superHeroServiceDAO.createSuperHero(superhero);
	}

	public List<Superhero> getAllSuperHero() {
		return superHeroServiceDAO.getAllSuperHero();
	}

	public Superhero getSuperHero(String superHeroName) {
		return superHeroServiceDAO.getSuperHero(superHeroName);
	}

}
