package com.superhero.pojo;

import java.util.ArrayList;
import java.util.List;

public class Superhero {

	private String name;
	private String pseudonym;
	private String publisher;
	private List<Skills> skills;
	private List<Allies> allies;
	private String first_appearance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<Skills> getSkills() {
		if (skills == null) {
			return new ArrayList<Skills>();
		} else {
			return skills;
		}
	}

	public List<Allies> getAllies() {
		if (allies == null) {
			return new ArrayList<Allies>();
		} else {
			return allies;
		}
	}

	public String getFirst_appearance() {
		return first_appearance;
	}

	public void setFirst_appearance(String first_appearance) {
		this.first_appearance = first_appearance;
	}

}
