package com.agenda.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentConfiguration {

	@Value("${olhovivo.token}")
	private String token;

	@Value("${olhovivo.url}")
	private String url;

	public String getToken() {
		return token;
	}

	public String getUrl() {
		return url;
	}

}
