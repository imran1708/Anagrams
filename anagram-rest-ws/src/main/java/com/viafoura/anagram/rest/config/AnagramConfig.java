package com.viafoura.anagram.rest.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.viafoura.anagram.rest.model.PropertiesHolder;

/**
 * @author imran Date 26-02-2020
 * 
 *         This class contains all the configurations belonging to Spring DI of
 *         Bean classes
 *
 */
@Configuration
public class AnagramConfig {

	/**
	 * @return
	 * @throws IOException
	 * 
	 *                     Read error.properties file from class-path which contains
	 *                     all the error messages. This bean can be used to get
	 *                     properties everywhere.
	 */
	@Bean
	@Qualifier
	public PropertiesHolder readProperties() throws IOException {
		Resource resource = new ClassPathResource("/errors.properties");
		return new PropertiesHolder(PropertiesLoaderUtils.loadProperties(resource));
	}
}
