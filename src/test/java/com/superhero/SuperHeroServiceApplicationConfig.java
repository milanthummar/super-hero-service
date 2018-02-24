package com.superhero;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.superhero.dao.SuperHeroServiceDAO;
import com.superhero.service.SuperHeroServiceService;

@Component
public class SuperHeroServiceApplicationConfig {

	@Bean
	public SuperHeroServiceDAO getSuperHeroServiceDAO() {
		return EasyMock.createMock(SuperHeroServiceDAO.class);
	}

	@Bean
	public SuperHeroServiceService getSuperHeroServiceService() {
		return EasyMock.createMock(SuperHeroServiceService.class);
	}
}
