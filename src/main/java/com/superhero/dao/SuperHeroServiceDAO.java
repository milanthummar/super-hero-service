package com.superhero.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.superhero.pojo.Superhero;

@Component
public class SuperHeroServiceDAO {

	private static Map<String, Superhero> dataMap = new HashMap<String, Superhero>();

	public boolean createSuperHero(Superhero superhero) {
		dataMap.put(superhero.getName(), superhero);
		return dataMap.containsKey(superhero.getName());
	}

	public List<Superhero> getAllSuperHero() {
		return dataMap.values().stream().collect(Collectors.toList());
	}

	public Superhero getSuperHero(String superHeroName) {
		return dataMap.get(superHeroName);
	}

}
