package com.viafoura.anagram.rest.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.viafoura.anagram.rest.model.PropertiesHolder;

@Configuration
public class AnagramConfig {

	@Bean
	@Qualifier
	public PropertiesHolder readProperties() throws IOException {
		Resource resource = new ClassPathResource("/errors.properties");
		return new PropertiesHolder(PropertiesLoaderUtils.loadProperties(resource)); 
	}
}
