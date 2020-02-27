package com.viafoura.anagram.rest.model;

import java.util.Properties;

public class PropertiesHolder {
	Properties properties;

	public PropertiesHolder(Properties properties) {
		this.properties = properties;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
